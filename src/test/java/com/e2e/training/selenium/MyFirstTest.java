package com.e2e.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by m on 2020-01-03.
 */
public class MyFirstTest extends TestBase {

  @Test
  public void myFirstTest() {
    driver.get("https://www.google.pl/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
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
