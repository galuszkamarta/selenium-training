package Litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by m on 2020-02-03.
 */

public class CartPage extends Page {
  public CartPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.get("http://localhost/litecart/en");
  }


  @FindBy(xpath = "//a[@href='http://localhost/litecart/en/checkout']")
  public WebElement ShoppingCartLink;

  @FindBy(xpath = "//input[@name='item[4d78797fbec0162d86361741abf2db41][quantity]']")
  public WebElement quantityInput;

  @FindBy(xpath = "//button[@name='update_cart_item']")
  public WebElement updateCartItemButton;

  @FindBy(xpath = "//a[@href='http://localhost/litecart/en/']")
  public WebElement closeShoppingCartBaton;


  public void deleteItemFromShoppingCart() {
    waitLoaderWrapper();
    int numberOfItem = driver.findElements(By.xpath("//span[@class='quantity']")).size();

    click(ShoppingCartLink);
    waitLoaderWrapper();
    for (int d = numberOfItem; d >= 0; d--) {
      waitForElementToBeGone("//div[@class='loader-wrapper']");
      type(quantityInput, Integer.toString(d));
      click(updateCartItemButton);
    }
  }

  public void waitLoaderWrapper() {
    waitForElementToBeGone("//div[@class='loader-wrapper']");
  }
}