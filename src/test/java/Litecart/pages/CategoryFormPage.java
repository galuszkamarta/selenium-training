package Litecart.pages;

import Litecart.model.Category;
import Litecart.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

/**
 * Created by g on 2020-04-18.
 */
public class CategoryFormPage extends Page {
  public CategoryFormPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//input[@value='1']//..")
  private WebElement enabledButton;

  @FindBy(xpath = "//input[@name='code']")
  private WebElement codeInput;

  @FindBy(xpath = "//input[@name='name[en]']")
  private WebElement nameCategoryInput;

  @FindBy(xpath = "//select[@name='google_taxonomy_id']")
  private WebElement googleTaxonomyIdChecker;

  @FindBy(xpath = "//input[@value='menu']")
  private WebElement dockMenuChecker;

  @FindBy(xpath = "//input[@value='tree']")
  private WebElement dockTreeChecker;

  @FindBy(xpath = "//select[@name='list_style']")
  private WebElement listStyleChecker;

  @FindBy(xpath = "//input[@name='image']")
  private WebElement photoInput;

  @FindBy(xpath = "//button[@name='save']")
  private WebElement saveCategoryBaton;

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=catalog&doc=edit_category&parent_id=0']");
  }

  public void registerNewCategory(Category category) {
    enabledButton.click();
    codeInput.sendKeys(category.getCode());
    nameCategoryInput.sendKeys(category.getNameCategory());
    selectFromDropdown(googleTaxonomyIdChecker, category.getGoogleTaxonomyID());
    dockMenuChecker.click();
    dockTreeChecker.click();
    selectFromDropdown(listStyleChecker, category.getListStyle());
    attachFile(photoInput, category.getPhoto()) ;
    saveCategoryBaton.click();
  }

  }
