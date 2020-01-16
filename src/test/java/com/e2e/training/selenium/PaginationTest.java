package com.e2e.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by g on 2020-01-16.
 */
public class PaginationTest extends TestBase {

  @Test
  public void myFirstTest() {
    driver.navigate().to("http://pagination.js.org/");
    WebElement demo1 = driver.findElement(By.cssSelector("#demo1"));
    List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
    List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

    pagination.get(2).click();
    wait.until(ExpectedConditions.stalenessOf(items.get(0)));
    items = demo1.findElements(By.cssSelector(".data-container ul li"));
    Assert.assertTrue(items.get(0).getText().equals("11"));
  }
}
