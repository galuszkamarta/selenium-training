package Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by m on 2020-01-13.
 */
public class ItemChecker extends TestBase {

  @Test
  public void itemCheckerTest() {
    wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^='#campaign-products']")));
    driver.findElement(By.cssSelector("a[href^='#campaign-products']")).click();

    String TitleCP = driver.findElement(By.xpath("//div[@class='name']")).getText();
    String RegularPriceCP = driver.findElement(By.xpath("//s[@class='regular-price']")).getText();
    String NewPriceCP = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getText();

    driver.findElement(By.xpath("//a[@class='link']")).click();

    Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title']")).getText(), TitleCP);
    Assert.assertEquals(driver.findElement(By.xpath("//del[@class='regular-price']")).getText(), RegularPriceCP);
    Assert.assertEquals(driver.findElement(By.xpath("//strong[@class='campaign-price']")).getText(), NewPriceCP);
  }
}
