package Litecart.pages;

import Litecart.app.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

/**
 * Created by m on 2020-01-24.
 */
public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Application app;


  public Page(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
    this.app = app;
  }


  public void selectFromDropdown(WebElement element, String text) {
    wait.until(
            ExpectedConditions.visibilityOf(element));
    wait.until(
            ExpectedConditions.visibilityOf(element)).sendKeys(text);
  }

  public void type(WebElement element, String text) {
    wait.until(ExpectedConditions.visibilityOf(element)).clear();
    wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
  }

  public void click(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }

  public void fillForm(WebElement element, String text) {
    click(element);
    type(element, text);
  }

  public void waitForElementToBeGone(String locator) {
    if (isElementPresent(locator)) {
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
  }

  public void attachFile(WebElement element, File text) {
    wait.until(
            ExpectedConditions.visibilityOf(element));
    wait.until(
            ExpectedConditions.visibilityOf(element)).sendKeys(text.getAbsolutePath());
  }

  public void BrowserLog() {
    List<LogEntry> logList = driver.manage().logs().get("browser").getAll();
    if (logList.size()!= 0) {
      for (LogEntry l : logList)
        System.out.println(l);
    }
    else
      System.out.println("The Log has not new messeges!");
  }

  boolean isElementPresent(String locator) {
    return driver.findElements(By.xpath(locator)).size() > 0;
  }

  public void clickLinksByIndex(List<WebElement> products, int i) {
    products.get(i).click();
  }

  public abstract void open();
}


