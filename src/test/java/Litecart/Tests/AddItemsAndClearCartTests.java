package Litecart.Tests;

import Litecart.model.Item;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by m on 2020-02-06.
 */

@RunWith(DataProviderRunner.class)
public class AddItemsAndClearCartTests extends TestBase {

  @Test
  @UseDataProvider(value = "validItems", location = DataProviders.class)
  public void testAddItemsAndClearCart(Item item) {
    app.landingPage.open();
    for (int i = 0; i <= 2; i++) {
      app.landingPage.chooseFirstItem();
      app.itemPage.addItemToCart(item);
      app.landingPage.openShoppingCart();
      app.cartPage.waitLoaderWrapper();
      app.landingPage.open();
    }
    app.cartPage.deleteItemFromShoppingCart();
  }
}


