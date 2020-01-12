package Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by m on 2020-01-10.
 */
public class LabelChecker extends TestBase{


  @Test
  public void labelChecker() {
    driver.findElement(By.cssSelector("a[href^='http://localhost/litecart/en/rubber-ducks-c-1']")).click();
    List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-xs-halfs col-sm-thirds col-md-fourths col-lg-fifths']"));
    List<WebElement> stickersNew = driver.findElements(By.xpath("//*[@class='sticker new']"));
    List<WebElement> stickersSale = driver.findElements(By.xpath("//*[@class='sticker sale']"));
    Assert.assertEquals(products.size(), stickersNew.size() + stickersSale.size());
  }
}
