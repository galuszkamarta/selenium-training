package Litecart.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
public class CountriesListPage extends Page {

  public CountriesListPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//tr//td[5]")
  private List<WebElement> countriesRow;

  @FindBy(xpath = "//tr//td[6]")
  private List<WebElement> webElementsZone;

  @FindBy(xpath = "//button[@name='save']")
  private WebElement saveButton;

  @FindBy(xpath = "//tr//td[5]//a")
  private List<WebElement> countriesName;

  @FindBy (xpath = "//tr//td[3]")
  private List<WebElement> zonesInEditCountry;



  public void open() {driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");}

  public List<String> countriesChecker() {
    List<String> countriesList = new ArrayList<String>();
    for (WebElement e : countriesRow) {
      countriesList.add(e.getText());
    }
    return countriesList;
  }


  public void zonesChecker() {
    List<String> numberofZonesList = new ArrayList<String>();
    for (WebElement e : webElementsZone) {
      numberofZonesList.add(e.getText());
    }
    for (int i = 0; i < numberofZonesList.size(); i++) {
      if (Integer.valueOf(numberofZonesList.get(i)) > 0) {
        clickLinksByIndex(countriesName, i);
        List<String> zoneList = new ArrayList<String>();
        for (WebElement e : zonesInEditCountry) {
          zoneList.add(e.getText());
        }
        List<String> copy = zoneList;
        Collections.sort(copy);
        Assert.assertEquals(zoneList, copy);
        saveButton.click();
      }
    }
  }
}

