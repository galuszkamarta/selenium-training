package Litecart.Tests;

import org.junit.Test;

/**
 * Created by m on 2020-05-29.
 */
public class MenuCheckerTest extends TestBase {

  @Test
  public void testMenuChecker() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.adminPanelPage.menuPanelChecker();
  }
}
