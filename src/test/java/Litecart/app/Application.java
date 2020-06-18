package Litecart.app;

import Litecart.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by m on 2020-01-24.
 */

  public class Application {

  private WebDriver driver;
  public AddNewCountryPage addNewCountryPage;
  public AdminPanelLoginPage adminPanelLoginPage;
  public AdminPanelPage adminPanelPage;
  public CartPage cartPage;
  public CatalogListPage catalogListPage;
  public CategoryFormPage categoryFormPage;
  public CountriesListPage countriesListPage;
  public CustomerListPage customerListPage;
  public EditProductPage editProductPage;
  public GeoZonesListPage geoZonesListPage;
  public ItemPage itemPage;
  public LandingPage landingPage;
  public RegistrationPage registrationPage;

  public Application() {
    driver = new ChromeDriver();
    addNewCountryPage = new AddNewCountryPage(driver);
    adminPanelLoginPage = new AdminPanelLoginPage(driver);
    adminPanelPage = new AdminPanelPage(driver);
    cartPage = new CartPage(driver);
    catalogListPage = new CatalogListPage(driver);
    categoryFormPage = new CategoryFormPage(driver);
    countriesListPage = new CountriesListPage(driver);
    customerListPage = new CustomerListPage(driver);
    editProductPage = new EditProductPage(driver);
    geoZonesListPage = new GeoZonesListPage(driver);
    itemPage = new ItemPage(driver);
    landingPage = new LandingPage(driver);
    registrationPage = new RegistrationPage(driver);
  }

  public void quit() {
    driver.quit();
  }
}


