package Litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by m on 2020-06-04.
 */
public class AddNewCountryPage extends Page {
  public AddNewCountryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy (xpath = "//i[@class='fa fa-external-link']")
  private List<WebElement> externalLink;


  private String countryForm = "//form[@name='country_form']";

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=countries&doc=edit_country");
  }

  public void linkOpener() {
    waitForElementToBeGone(countryForm);
    for (int i = 0; i < externalLink.size(); i++) {
      String mainWindow = driver.getWindowHandle();
      clickLinksByIndex(externalLink, i);
      new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
      Set<String> allHandles = driver.getWindowHandles();
      for (String handle : allHandles) {
        if (!handle.equals(mainWindow)) driver.switchTo().window(handle);
      }
      driver.close();
      driver.switchTo().window(mainWindow);
    }
  }
}
