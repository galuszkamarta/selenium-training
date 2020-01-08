package com.e2e.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by g on 2020-01-07.
 */
public class MyThirdTest  extends TestBase  {

  @Test
  public void myFirstTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("//input[@name='btnK']")).click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }

  @Test
  public void mySecondTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("//input[@name='btnK']")).click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }

  @Test
  public void myThirdTest() {
    driver.get("https://www.google.pl/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("//input[@name='btnK']")).click();
    wait.until(titleIs("webdriver - Szukaj w Google"));
  }
}
