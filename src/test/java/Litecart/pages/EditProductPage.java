package Litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by m on 2020-05-29.
 */
public class EditProductPage extends Page {
  public EditProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy (xpath = "//button[@name='save']")
  private WebElement saveButton;

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=catalog&doc=edit_product&category_id=1&product_id=4");
  }

  public void close() {
    click(saveButton);
  }



}
