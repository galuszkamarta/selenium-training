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

  @FindBy(xpath = "//div[@class='name']")
  private WebElement tileCP;

  @FindBy(xpath = "//s[@class='regular-price']")
  private WebElement regularPriceCP;

  @FindBy(xpath = "//strong[@class='campaign-price']")
  private WebElement campaignPriceCP;

  public LandingPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public String getTitleCP() {
    return tileCP.getText();
  }
  public String getRegularPriceCP() {
    return regularPriceCP.getText();
  }

  public String getCampaignPriceCP() {
    return campaignPriceCP.getText();
  }


  @Override
  public void open() {
    driver.get("http://localhost/litecart/en/");
  }

  public void chooseFirstItem() {
    click(firstItem);
    waitForElementToBeGone("//div[@class='loader-wrapper']");
  }

  public void openShoppingCart() {
  click(ShoppingCartLink);
  }

}

