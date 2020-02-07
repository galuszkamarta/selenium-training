package Litecart.app;

import Litecart.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by m on 2020-01-24.
 */

  public class Application {

  private WebDriver driver;


  public RegistrationPage registrationPage;
  public AdminPanelLoginPage adminPanelLoginPage;
  public CustomerListPage customerListPage;
  public LandingPage landingPage;
  public CartPage cartPage;
  public ItemPage itemPage;

  public Application() {
    driver = new ChromeDriver();
    registrationPage = new RegistrationPage(driver);
    adminPanelLoginPage = new AdminPanelLoginPage(driver);
    customerListPage = new CustomerListPage(driver);
    landingPage = new LandingPage(driver);
    cartPage = new CartPage(driver);
    itemPage = new ItemPage(driver);
  }

  public void quit() {
    driver.quit();
  }





}


