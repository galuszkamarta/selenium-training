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
    click("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']");
    fillAddNewCategoryForm(photo, code, name);
  }

  public void fillAddNewCategoryForm(File photo, String code, String name) {
    click("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=edit_category&parent_id=0']");
    fillForm("//input[@name='code']", code);
    fillForm("//input[@name='name[en]']", name);
    selectFromDropdown("//select[@name='parent_id']", "Rubber Ducks");
    selectFromDropdown("//select[@name='google_taxonomy_id']", "Animals & Pet Supplies");
    click("//input[@name='dock[]']");
    selectFromDropdown("//select[@name='list_style']", "Rows");
    attachFile("//input[@name='image']", photo);
    click("//button[@name='save']");
  }

}
