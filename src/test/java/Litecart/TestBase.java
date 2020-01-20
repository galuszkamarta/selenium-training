package Litecart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by m on 2020-01-05.
 */

public class TestBase {

  public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
  public WebDriver driver;
  public WebDriverWait wait;

  public boolean isElementPresent(By locator) {
    try {
      wait.until((WebDriver d) -> d.findElement(locator)); // jawne oczekiwanie
      // driver.findElement(locator); // niejawne oczekiwanie
      return true;
    } catch (TimeoutException ex) { // jawne oczekiwanie
      // } catch (NoSuchElementException ex) { // niejawne oczekiwanie
      return false;
    }
  }

  public boolean areElementsPresent(By locator) {
    try {
      return driver.findElements(locator).size() > 0;
    } catch (InvalidSelectorException ex) {
      return false;
    }
  }


  @Before
  public void start() {
    initLiteCart();
  }

  public void initLiteCart() {

      if (tldriver.get() != null) {
        driver = tldriver.get();
        wait = new WebDriverWait(driver, 10);
        return;
      }

      driver = new ChromeDriver();
      // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // niejawne oczekiwanie
      tldriver.set(driver);
      System.out.println(((HasCapabilities) driver).getCapabilities());
      wait = new WebDriverWait(driver, 10);

      Runtime.getRuntime().addShutdownHook(
              new Thread(() -> {
                driver.quit();
                driver = null;
              }));
    driver.navigate().to("http://localhost/litecart/");
  }


  public void loginAdmin() {
    goToPage("http://localhost/litecart/admin");
    fillForm("//input[@name='username']", "admin");
    fillForm("//input[@name='password']", "admin");
    click("//button[@name='login']");
  }

  public void goToPage(String locator) {
    driver.navigate().to(locator);
  }

  public void selectFromDropdown(String locator, String text) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElement(By.xpath(locator)).sendKeys(text);
  }

  public void type(String locator, String text) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElement(By.xpath(locator)).clear();
    driver.findElement(By.xpath(locator)).sendKeys(text);
  }

  public void click(String locator) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElement(By.xpath(locator)).click();
  }

  public void clickLinksByIndex(String locator, int index) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElements(By.xpath(locator)).get(index).click();
  }

  public void fillForm(String locator, String text) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElement(By.xpath(locator)).click();
    driver.findElement(By.xpath(locator)).clear();
    driver.findElement(By.xpath(locator)).sendKeys(text);
  }

  public void attachFile(String locator, File text) {
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    driver.findElement(By.xpath(locator)).sendKeys(text.getAbsolutePath());
  }

  public void waitForElementToBeGone(String locator) {
    if (isElementPresent(locator)) {
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
  }

  boolean isElementPresent(String locator) {
    return driver.findElements(By.xpath(locator)).size() > 0;
  }

   public void waitnUntilPageIsLoaded() {}

  @After
  public void stop() {
//    driver.quit();
//    driver = null;
  }
}


