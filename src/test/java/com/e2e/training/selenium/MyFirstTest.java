package com.e2e.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by m on 2020-01-03.
 */
public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-fullscreen");
    // driver = new ChromeDriver(options);
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("unexpectedAlertBehaviour", "dismiss");
    driver = new InternetExplorerDriver();
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void myFirstTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("//input[@name='btnK']")).click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
