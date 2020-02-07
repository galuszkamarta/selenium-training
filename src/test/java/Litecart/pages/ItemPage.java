package Litecart.pages;

import Litecart.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by m on 2020-02-03.
 */
public class ItemPage extends Page {
  public ItemPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.get("http://localhost/litecart/en/rubber-ducks-c-1/yellow-duck-p-1"); }

  @FindBy(xpath = "//input[@name='quantity']")
  private WebElement quantityInput;

  @FindBy(xpath = "//select[@name='options[Size]']")
  private WebElement sizeInput;

  @FindBy(xpath = "//button[@name='add_cart_product']")
  private WebElement addCartProduct;

  @FindBy(xpath = "//div/span[@class='quantity']")
  private WebElement quantityChecker;

  @FindBy(xpath = "//button[@aria-label='Close']")
  private WebElement closeItemBaton;



  public void addItemToCart(Item item) {
    waitForElementToBeGone("//div[@class='loader-wrapper']");
    type(quantityInput, item.getQuantity());
    selectFromDropdown(sizeInput,item.getSize());
    click(addCartProduct);
    String numberOfItemsBeforeAdding = driver.findElement(By.xpath("//div/span[@class='quantity']")).getText();
    waitForElementToChange(quantityChecker, Integer.toString((Integer.valueOf(numberOfItemsBeforeAdding) + 1)));
    waitForElementToBeGone("//div[@class='loader-wrapper']");
    click(closeItemBaton);
  }

  private void waitForElementToChange(WebElement element, String expected) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.textToBePresentInElement(element, expected));
  }


  }