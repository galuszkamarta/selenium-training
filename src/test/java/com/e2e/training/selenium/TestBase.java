package com.e2e.training.selenium;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


/**
 * Created by m on 2020-01-07.
 */
public class TestBase {

  public static ThreadLocal<EventFiringWebDriver> tldriver = new ThreadLocal<>();
  public EventFiringWebDriver driver;
  public WebDriverWait wait;

  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
      File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screen = new File("sreen-" + System.currentTimeMillis() + ".png");
      try {
        Files.copy(tmp, screen);
      } catch (IOException e) {
       e.printStackTrace();
       }
      System.out.println(screen);
    }
  }


  @Before
  public void start() {
    if (tldriver.get() != null) {
      driver = tldriver.get();
      wait = new WebDriverWait(driver, 10);
      return;
    }

    driver = new EventFiringWebDriver(new ChromeDriver());
    driver.register(new MyListener());
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
