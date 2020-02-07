package Litecart.Tests;

import Litecart.model.Item;
import com.tngtech.java.junit.dataprovider.DataProvider;
import Litecart.model.Customer;

import static Litecart.model.Item.newEntity;

/**
 * Created by m on 2020-01-24.
 */
public class DataProviders {
  @DataProvider
  public static Object[][] validCustomers() {
    return new Object[][]{
            {Customer.newEntity()
                    .withFirstname("Anna").withLastname("Gut").withPhone("+48123456789")
                    .withAddress("Gliwicka").withPostcode("40-843").withCity("Katowice")
                    .withCountry("Poland")
                    .withEmail("gut" + System.currentTimeMillis() + "@litecart.com")
                    .withPassword("qwerty").build()},
                /* ... */
    };
  }

  @DataProvider
  public static Object[][] validItems() {
    return new Object[][]{
            {Item.newEntity()
                    .withSize("Small").withQuantity("1").build()},
                /* ... */
    };
  }

}
