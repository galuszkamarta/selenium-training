package Litecart.Tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by m on 2020-06-03.
 */
public class ItemCheckerTest extends TestBase {

  @Test
  public void testItemChecker() {
    app.landingPage.open();
    String tileCP = app.landingPage.getTitleCP();
    String regularPriceCP = app.landingPage.getRegularPriceCP();
    String campaignPriceCP = app.landingPage.getCampaignPriceCP();

    app.itemPage.open();
    String titleItem = app.itemPage.getTileItem();
    String regularPriceItem = app.itemPage.getRegularPrice();
    String campaignPriceItem = app.itemPage.getCampaignPrice();

    Assert.assertEquals(titleItem, tileCP);
    Assert.assertEquals(regularPriceItem, regularPriceCP);
    Assert.assertEquals(campaignPriceItem, campaignPriceCP);
  }
}
