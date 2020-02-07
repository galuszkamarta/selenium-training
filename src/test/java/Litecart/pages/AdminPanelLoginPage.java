package Litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by m on 2020-01-24.
 */
public class AdminPanelLoginPage extends Page {

  public AdminPanelLoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.get("http://localhost/litecart/admin");
  }

  @FindBy(xpath = "//input[@name='username']")
  public WebElement usernameInput;

  @FindBy(xpath = "//input[@name='password']")
  public WebElement passwordInput;

  @FindBy(xpath = "//button[@name='login']")
  public WebElement loginBaton;


  public AdminPanelLoginPage enterUsername(String username) {
   fillForm(usernameInput, username);
   return this;
  }

  public AdminPanelLoginPage enterPassword(String password) {
    fillForm(passwordInput, password);
    return this;
  }

  public void submitLogin() {
    click(loginBaton);
    wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));
  }


  public void EnterAdminCredentials() {
    enterUsername("admin").enterPassword("admin").submitLogin();
  }
}
