package Litecart.Tests;

import Litecart.model.Category;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by m on 2020-04-18.
 */

@RunWith(DataProviderRunner.class)
public class AddNewCategoryTest extends TestBase  {

  @Test
  @UseDataProvider(value = "validCategory" , location = DataProviders.class)
  public void testAddItemsAndClearCart(Category category) {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.catalogListPage.open();
    Set<String> oldIds = app.catalogListPage.getCatalogIds();
    app.categoryFormPage.open();
    app.categoryFormPage.registerNewCategory(category);
    Set<String> newIds = app.catalogListPage.getCatalogIds();

    assertTrue(newIds.containsAll(oldIds));
    assertTrue(newIds.size() == oldIds.size() + 1);
  }

}








