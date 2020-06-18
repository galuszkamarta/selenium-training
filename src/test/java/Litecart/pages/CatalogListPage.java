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
 * Created by m on 2020-05-28.
 */
public class CatalogListPage extends Page {

  public CatalogListPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }


  @FindBy(xpath = "//table//tbody/tr")
  private List<WebElement> catalogRows;

  @FindBy(xpath = "//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']")
  private WebElement categoryOfcatalogOpen;

  @FindBy(xpath = "//tbody//tr//td//img/following-sibling::a")
  private List<WebElement> CategoryOfCatalog;

  @FindBy(xpath = "//tbody//tr//td//img/following-sibling::a")
  private List<WebElement> products;

  @FindBy(xpath = "//button[@name='save']")
  private WebElement saveButton;

  private String catalogLocator = "//tbody//tr//td//img/following-sibling::a";

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
  }

  public Set<String> getCatalogIds() {
    return catalogRows.stream()
            .map(e -> e.findElements(By.tagName("td")).get(2).getText())
            .collect(toSet());
  }

  public void openCatalogCategory() {
    click(categoryOfcatalogOpen);
  }

  public void itemsChecker() {
    waitForElementToBeGone(catalogLocator);
    BrowserLog();
    for (int i = 0; i < CategoryOfCatalog.size(); i++) {
      clickLinksByIndex(products, i);
      BrowserLog();
      click(saveButton);
    }
  }







}

