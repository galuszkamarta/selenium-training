package com.e2e.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;

/**
 * Created by m on 2020-01-07.
 */
public class TestBase {

  public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    if (tldriver.get() != null) {
      driver = tldriver.get();
      wait = new WebDriverWait(driver, 10);
      return;
    }

    driver = new ChromeDriver();
    tldriver.set(driver);
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
