package com.e2e.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

/**
 * Created by m on 2020-01-03.
 */
public class MyFirstTest extends TestBase {

  @Test
  public void getBrowserLogs() {
    driver.navigate().to("https://www.google.pl/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //System.out.println(driver.manage().logs().getAvailableLogTypes());
    //driver.manage().logs().get("performance").forEach(l -> System.out.println(l));
    for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
       System.out.println(l);
     }

  }

  @Test
  public void myFirstTest() {
    driver.get("https://www.google.pl/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("_btnK")).click();
  }

  @Test
  public void mySecondTest() {
    driver.get("https://www.google.pl/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
  }

  @Test
  public void myThirdTest() {
    driver.get("https://www.google.pl/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
  }
}
