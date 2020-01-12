package Litecart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by g on 2020-01-05.
 */
public class TestBase {
  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    initLiteCart();
  }

  public void initLiteCart() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
    driver.navigate().to("http://localhost/litecart/");
  }

  public void loginAdmin() {
    driver.navigate().to("http://localhost/litecart/admin");
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@name='login']")).click();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }
}
