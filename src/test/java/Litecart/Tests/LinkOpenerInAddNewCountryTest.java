package Litecart.Tests;

import org.junit.Test;

/**
 * Created by m on 2020-06-04.
 */
public class LinkOpenerInAddNewCountryTest extends TestBase{

  @Test
  public void testLinkOpenerInAddNewCountry() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.adminPanelPage.open();
    app.countriesListPage.open();
    app.addNewCountryPage.open();
    app.addNewCountryPage.linkOpener();
  }
}
