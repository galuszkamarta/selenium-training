package Litecart.Tests;

import Litecart.model.Customer;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by m on 2020-01-24.
 */

@RunWith(DataProviderRunner.class)
public class CustomerRegistracionTests extends TestBase{

  @Test
  @UseDataProvider(value = "validCustomers", location = DataProviders.class)
  public void canRegisterCustomer(Customer customer) {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.customerListPage.open();
    Set<String> oldIds = app.customerListPage.getCustomerIds();
    app.registrationPage.registerNewCustomer(customer);
    app.customerListPage.open();
    Set<String> newIds = app.customerListPage.getCustomerIds();
    assertTrue(newIds.containsAll(oldIds));
    assertTrue(newIds.size() == oldIds.size() + 1);
  }

}
