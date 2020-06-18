package Litecart.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by m on 2020-05-29.
 */
public class AdminPanelPage extends Page {
  public AdminPanelPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy (xpath = "//li[@id='app-']/a")
  private List<WebElement> CategoryOfMenu;

  @FindBy (xpath = "//h1[text()]")
  private WebElement titleText;


  private String menuLocator = "//input[@class='form-control']";

  public void open() {driver.get("http://localhost/litecart/admin/");}

  public void menuPanelChecker() {
    waitForElementToBeGone(menuLocator);
    for (int i = 0; i < CategoryOfMenu.size(); i++) {
      clickLinksByIndex(CategoryOfMenu, i);
      titleText.getText();
    }
  }
}


