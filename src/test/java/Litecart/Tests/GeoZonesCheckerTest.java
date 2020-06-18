package Litecart.Tests;

import org.junit.Test;

/**
 * Created by m on 2020-06-04.
 */
public class GeoZonesCheckerTest extends TestBase {

  @Test
  public void testGeoZonesChecker() {
    app.adminPanelLoginPage.open();
    app.adminPanelLoginPage.EnterAdminCredentials();
    app.geoZonesListPage.open();
    app.geoZonesListPage.zonesCheckerInEditGeoZone();
  }
}
