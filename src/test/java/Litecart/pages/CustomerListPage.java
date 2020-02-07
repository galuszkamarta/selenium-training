package Litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by m on 2020-01-24.
 */
  public class CustomerListPage extends Page{

    public CustomerListPage(WebDriver driver) {
      super(driver);
      PageFactory.initElements(driver, this);
    }

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
  }

  @FindBy(xpath = "//table//tbody/tr")
  private List<WebElement> customerRows;

  public Set<String> getCustomerIds() {
    return customerRows.stream()
            .map(e -> e.findElements(By.tagName("td")).get(2).getText())
            .collect(toSet());
  }

}
