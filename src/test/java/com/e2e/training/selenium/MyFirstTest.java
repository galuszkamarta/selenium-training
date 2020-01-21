package com.e2e.training.selenium;

import net.lightbody.bmp.core.har.Har;
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
    proxy.newHar();
    driver.navigate().to("http://selenium.ru");

    Har har = proxy.endHar();
    har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));

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
