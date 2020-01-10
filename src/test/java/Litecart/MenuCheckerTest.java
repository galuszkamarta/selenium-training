package Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by m on 2020-01-09.
 */
public class MenuCheckerTest extends TestBase {

  @Test
  public void menuCheckerTest() {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
    int numberOfItems = driver.findElements(By.cssSelector("li#app-")).size();
    for (int i = 0; i < numberOfItems; i++) {
      driver.findElements(By.cssSelector("li#app-")).get(i).click();
      Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
    }
  }

}



