package com.e2e.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    // driver.findElement(By.name("q")).sendKeys("webdriver");  // niejawne oczekiwanie
    wait.until(presenceOfElementLocated(By.name("q"))).sendKeys("webdriver"); // jawne oczekiwanie
    WebElement btnK = driver.findElement(By.name("btnK"));
    btnK.click();
    assertTrue(isElementPresent(By.cssSelector(".rc")));
  }

  @Test
  public void mySecondTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    WebElement btnK = driver.findElement(By.name("btnK"));
    btnK.click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }

  @Test
  public void myThirdTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    WebElement btnK = driver.findElement(By.name("btnK"));
    btnK.click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }
}
