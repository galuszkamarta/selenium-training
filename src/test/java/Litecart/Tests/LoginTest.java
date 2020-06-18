package Litecart.Tests;

import org.junit.Test;

/**
 * Created by m on 2020-06-01.
 */
public class LoginTest extends TestBase {

  @Test
  public void testLogin() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
  }
}
