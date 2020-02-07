package Litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by m on 2020-02-06.
 */
public class LandingPage extends Page {

  @FindBy(xpath = "//div[@class='product column shadow hover-light']//a[@class='link']")
  public WebElement firstItem;

  @FindBy(xpath = "//a[@href='http://localhost/litecart/en/checkout']")
  private WebElement ShoppingCartLink;

  public LandingPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public void open() {
    driver.get("http://localhost/litecart/en/");
  }

  public void chooseFirstItem() {
    click(firstItem);
  }

  public void openShoppingCart() {
  click(ShoppingCartLink);
  }

}


