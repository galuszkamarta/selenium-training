package Litecart.Tests;

import org.junit.Test;

/**
 * Created by m on 2020-05-29.
 */
public class CatalogOfItemCheckerTest extends TestBase {

  @Test
  public void testCatalogOfItemChecker() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.catalogListPage.open();
    app.catalogListPage.openCatalogCategory();
    app.catalogListPage.itemsChecker();
    }
}


