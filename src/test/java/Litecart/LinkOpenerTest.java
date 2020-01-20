package Litecart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by m on 2020-01-19.
 */
public class LinkOpenerTest extends TestBase {
  @Test
  public void testLinkOpener() {
    loginAdmin();

    click("//a[@href='http://localhost/litecart/admin/?app=countries&doc=countries']");
    click("//a[@class='btn btn-default']");
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-external-link']")));
    int links = driver.findElements(By.xpath("//i[@class='fa fa-external-link']")).size();
    for (int i = 0; i < links; i++) {

      String mainWindow = driver.getWindowHandle();


      clickLinksByIndex("//i[@class='fa fa-external-link']", i);
      new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
      Set<String> allHandles = driver.getWindowHandles();
      for (String handle : allHandles) {
        if (!handle.equals(mainWindow)) driver.switchTo().window(handle);
      }
      driver.close();
      driver.switchTo().window(mainWindow);
    }
  }
}
