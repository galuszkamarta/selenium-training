package Litecart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

/**
 * Created by m on 2020-01-21.
 */
public class CatalogOfItemCheckerTest extends TestBase {

  @Test
  public void testCatalogOfItems() {
    loginAdmin();
    click("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']");
    waitForElementToBeGone("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']");
    click("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']");
    ItemsChecker();
  }

  public void ItemsChecker() {
    waitForElementToBeGone("//tbody//tr//td//img/following-sibling::a");
    int numberOfItem = driver.findElements(By.xpath("//tbody//tr//td//img/following-sibling::a")).size();
    BrowserLog();

    for (int i = 0; i < numberOfItem; i++) {
      clickLinksByIndex("//tbody//tr//td//img/following-sibling::a", i);
      BrowserLog();
      click("//button[@name='save']");
    }
  }

  private void BrowserLog() {
    List<LogEntry> logList = driver.manage().logs().get("browser").getAll();
    if (logList.size()!= 0) {
      for (LogEntry l : logList)
        System.out.println(l);
    }
    else
      System.out.println("The Log has not new messeges!");
  }
}


