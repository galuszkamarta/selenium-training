package Litecart.pages;

import Litecart.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by m on 2020-01-24.
 */

public class RegistrationPage extends Page {
  public RegistrationPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }



  public void open() {
    driver.get("http://localhost/litecart/en/create_account");
  }

  @FindBy(name = "firstname")
  public WebElement firstnameInput;

  @FindBy(name = "lastname")
  public WebElement lastnameInput;

  @FindBy(name = "address1")
  public WebElement address1Input;

  @FindBy(name = "postcode")
  public WebElement postcodeInput;

  @FindBy(name = "city")
  public WebElement cityInput;

  @FindBy(xpath = "//div[@class='row']//input[@name='email']")
  public WebElement emailInput;

  @FindBy(name = "phone")
  public WebElement phoneInput;

  @FindBy(xpath = "//div[@class='row']//input[@name='password']")
  public WebElement passwordInput;

  @FindBy(name = "confirmed_password")
  public WebElement confirmedPasswordInput;

  @FindBy(name = "create_account")
  public WebElement createAccountButton;

  public void selectCountry(String country) {
    driver.findElement(By.xpath("//select[@name='country_code']")).sendKeys(country);
  }


  public void registerNewCustomer(Customer customer) {
    open();
    firstnameInput.sendKeys(customer.getFirstname());
    lastnameInput.sendKeys(customer.getLastname());
    address1Input.sendKeys(customer.getAddress());
    postcodeInput.sendKeys(customer.getPostcode());
    cityInput.sendKeys(customer.getCity());
    selectCountry(customer.getCountry());
    emailInput.sendKeys(customer.getEmail());
    phoneInput.sendKeys(customer.getPhone());
    passwordInput.sendKeys(customer.getPassword());
    confirmedPasswordInput.sendKeys(customer.getPassword());
    createAccountButton.click();
  }
}