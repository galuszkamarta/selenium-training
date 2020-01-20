package Litecart;

import org.junit.Test;

/**
 * Created by m on 2020-01-15.
 */
public class NewCastomerTest extends TestBase {

  long now = System.currentTimeMillis();
  public String firstname = String.format("firstname%s", now);
  public String lastname = String.format("lastname%s", now);
  public String password = "password$s";
  public String email = String.format("lastname%s@litecart.com", now);

  @Test
  public void testNewCastomerCreation() {

    goToPage("http://localhost/litecart/en/");
    createAccount(firstname, lastname, email, password);
    logout();
    login(email, password);
    logout();
  }

  public void createAccount(String firstname, String lastname, String email, String password) {
    click("//a[@href='http://localhost/litecart/en/create_account']");
    fillForm("//input[@name='firstname']", firstname);
    fillForm("//input[@name='lastname']", lastname);
    selectFromDropdown("//select[@name='country_code']", "Poland");
    fillForm("//div[@class='row']//input[@name='email']", email);
    fillForm("//div[@class='row']//input[@name='password']", password);
    fillForm("//input[@name='confirmed_password']", password);
    click("//button[@name='create_account']");

  }

  public void login(String email, String password) {
    fillForm("//input[@name='email']", email);
    fillForm("//input[@name='password']", password);
    click("//button[@name='login']");
  }

  public void logout() {
    click("//a[@href='http://localhost/litecart/en/logout']");
  }

}
