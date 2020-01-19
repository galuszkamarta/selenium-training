package Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by m on 2020-01-16.
 */
public class AddItemsToShoppingCartTest extends TestBase {

  @Test
  public void testAddItemsToShoppingCart() {
    for (int i = 0; i <= 2; i++) {
      AddItemToShoppingCart();
      click("//img[@src='/litecart/images/logotype.png']/parent::*");
    }
    DeleteItemFromShoppingCart();
    click("//a[@href='http://localhost/litecart/en/']");
  }

  public void AddItemToShoppingCart() {
    click("//a[@href='http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1']");
    waitForElementToBeGone("//div[@class='loader-wrapper']");
    selectFromDropdown("//select[@name='options[Size]']", "Small");
    click("//button[@name='add_cart_product']");
    String numberOfItemsBeforeAdding = driver.findElement(By.xpath("//div/span[@class='quantity']")).getText();
    waitForElementToChange("//div/span[@class='quantity']", Integer.toString((Integer.valueOf(numberOfItemsBeforeAdding)+1)));
    click("//button[@aria-label='Close']");

    click("//a[@href='http://localhost/litecart/en/checkout']");
    waitForElementToBeGone("//div[@class='loader-wrapper']");
    click("//a[@href='http://localhost/litecart/en/']");
  }

  private void waitForElementToChange(String locator, String expected) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locator), expected));

  }

  public void DeleteItemFromShoppingCart() {

    int numberOfItem = driver.findElements(By.xpath("//span[@class='quantity']")).size();
    click("//a[@href='http://localhost/litecart/en/checkout']");
    for (int d = numberOfItem; d >= 0; d--) {
      waitForElementToBeGone("//div[@class='loader-wrapper']");

      type("//input[@name='item[4d78797fbec0162d86361741abf2db41][quantity]']", Integer.toString(d));
      click("//button[@name='update_cart_item']");
    }
  }

}
