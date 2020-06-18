package Litecart.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by m on 2020-06-01.
 */
public class GeoZonesListPage extends Page {
  public GeoZonesListPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//tr//td[3]//a")
  private List<WebElement> numberOfZones;

  @FindBy(xpath = "//tr//td[3]")
  private List<WebElement> zonesRow;

  @FindBy(xpath = "//button[@name='save']")
  private WebElement saveButton;

  private String geoZonesForm = "//form[@name='geo_zones_form']";

  public void open() {
    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
  }

  public void zonesCheckerInEditGeoZone() {
    waitForElementToBeGone(geoZonesForm);
    for (int i = 0; i < numberOfZones.size(); i++) {
      clickLinksByIndex(numberOfZones, i);
      List<String> zonesListInEditGeoZone = new ArrayList<String>();
      for (WebElement e : zonesRow) {
        zonesListInEditGeoZone.add(e.getText());
      }
      List<String> copy = zonesListInEditGeoZone;
      Collections.sort(copy);
      Assert.assertEquals(zonesListInEditGeoZone, copy);
      saveButton.click();
    }
  }
}