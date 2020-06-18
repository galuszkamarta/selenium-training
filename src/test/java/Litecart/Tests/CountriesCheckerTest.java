package Litecart.Tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by m on 2020-06-01.
 */
public class CountriesCheckerTest extends TestBase {

  @Test
  public void testCountriesChecker() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.countriesListPage.open();
    List<String> countryList = app.countriesListPage.countriesChecker();
    List<String> copy = countryList;
    Collections.sort(copy);
    Assert.assertEquals(countryList, copy);
  }

  @Test
  public void zonesCheckerTest() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.countriesListPage.open();
    app.countriesListPage.zonesChecker();
  }
}
