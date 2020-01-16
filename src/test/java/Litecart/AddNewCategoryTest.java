package Litecart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 * Created by g on 2020-01-15.
 */
public class AddNewCategoryTest extends TestBase {

  long now = System.currentTimeMillis();
  public String code = String.format("1%s", now);
  public String name = String.format("name%s", now);
  public File photo = new File("./src/test/resources/fish.png");


  @Test
  public void testAddCategory() {
    loginAdmin();
    goToCatalog();
    fillAddNewCategoryForm(photo, code, name);

  }

  public void goToCatalog() {
    driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
  }

  public void fillAddNewCategoryForm(File photo, String code, String name) {
    driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=edit_category&parent_id=0']")).click();

    driver.findElement(By.xpath("//input[@name='code']")).click();
    driver.findElement(By.xpath("//input[@name='code']")).clear();
    driver.findElement(By.xpath("//input[@name='code']")).sendKeys(code);

    driver.findElement(By.xpath("//input[@name='name[en]']")).click();
    driver.findElement(By.xpath("//input[@name='name[en]']")).clear();
    driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys(name);

    driver.findElement(By.xpath("//select[@name='parent_id']")).sendKeys("Rubber Ducks");

    driver.findElement(By.xpath("//select[@name='google_taxonomy_id']")).sendKeys("Animals & Pet Supplies");


    driver.findElement(By.xpath("//input[@name='dock[]']")).click();

    Select drpListStyle = new Select(driver.findElement(By.xpath("//select[@name='list_style']")));
    drpListStyle.selectByVisibleText("Rows");

    driver.findElement(By.xpath("//input[@name='image']")).sendKeys(photo.getAbsolutePath());

    driver.findElement(By.xpath("//button[@name='save']")).click();
  }

}
