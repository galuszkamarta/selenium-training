package Litecart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
  public void testNewCastomerCreation (){

    driver.get("http://localhost/litecart/en/");
    createAccount(firstname, lastname, email, password);
    logout();
    login(email, password);
    logout();
  }

  public void createAccount(String firstname, String lastname, String email, String password) {
    driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/create_account']")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(firstname);

    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(lastname);

    driver.findElement(By.name("country_code")).sendKeys("Poland");

    driver.findElement(By.xpath("//div[@class='row']//input[@name='email']")).click();
    driver.findElement(By.xpath("//div[@class='row']//input[@name='email']")).clear();
    driver.findElement(By.xpath("//div[@class='row']//input[@name='email']")).sendKeys(email);

    driver.findElement(By.xpath("//div[@class='row']//input[@name='password']")).click();
    driver.findElement(By.xpath("//div[@class='row']//input[@name='password']")).clear();
    driver.findElement(By.xpath("//div[@class='row']//input[@name='password']")).sendKeys(password);

    driver.findElement(By.name("confirmed_password")).click();
    driver.findElement(By.name("confirmed_password")).clear();
    driver.findElement(By.name("confirmed_password")).sendKeys(password);

    driver.findElement(By.xpath("//button[@name='create_account']")).click();
  }


  public void login(String email, String password) {
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(email);

    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);

    driver.findElement(By.xpath("//button[@name='login']")).click();
  }

  public void logout() {
    driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/logout']")).click();
  }

}
