package com.e2e.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by m on 2020-01-07.
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
  }

  @After
  public void stop() {
    // driver.quit();
    // driver = null;
  }
}
