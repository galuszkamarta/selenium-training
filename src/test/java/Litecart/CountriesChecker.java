package Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by m on 2020-01-12.
 */

public class CountriesChecker extends TestBase {

  @Test
  public void countriesCheckerTest() {
    loginAdmin();
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
    driver.findElement(By.xpath("//*[text()='Countries']/parent::*")).click();
    List<WebElement> countries = driver.findElements(By.xpath("//tr//td[5]"));
    List<String> countriesList = new ArrayList<String>();
    for (WebElement e : countries) {
      countriesList.add(e.getText());
    }
    List<String> copy = countriesList;
    Collections.sort(copy);
    Assert.assertEquals(countriesList, copy);
  }


  @Test
  public void zonesCheckerTest() {
    loginAdmin();
    wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Countries']/parent::*")));

    driver.findElement(By.cssSelector("a[href=\"http://localhost/litecart/admin/?app=countries&doc=countries")).click();
    wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//tr//td[6]")));
    List<WebElement> webElementsZone = driver.findElements(By.xpath("//tr//td[6]"));
    List<String> numberofZonesList = new ArrayList<String>();
    for (WebElement e : webElementsZone) {
      numberofZonesList.add(e.getText());
    }
    for (int i = 0; i < numberofZonesList.size(); i++) {
      if (Integer.valueOf(numberofZonesList.get(i)) > 0) {
        List<WebElement> countries = driver.findElements(By.xpath("//tr//td[5]//a"));
        countries.get(i).click();
        List<WebElement> zones = driver.findElements(By.xpath("//tr//td[3]"));
        List<String> zoneList = new ArrayList<String>();
        for (WebElement e : zones) {
          zoneList.add(e.getText());
        }
        List<String> copy = zoneList;
        Collections.sort(copy);
        Assert.assertEquals(zoneList, copy);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='save']")));
        driver.findElement(By.xpath("//*[text()='Countries']/parent::*")).click();
      }
    }
  }


  @Test
  public void geoZonesCheckerTest() {
    loginAdmin();
    driver.findElement(By.xpath("//*[text()='Geo Zones']/parent::*")).click();
    wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//tr//td[3]//a")));
    int nameOfCountries = driver.findElements(By.xpath("//tr//td[3]//a")).size();
    for (int i = 0; i < nameOfCountries; i++) {
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td[3]//a")));
      driver.findElements(By.xpath("//tr//td[3]//a")).get(i).click();

      List<WebElement> zones = driver.findElements(By.xpath("//tr//td[3]"));
      List<String> zoneList = new ArrayList<String>();
      for (WebElement e : zones) {
        zoneList.add(e.getText());
      }
      List<String> copy = zoneList;
      Collections.sort(copy);
      Assert.assertEquals(zoneList, copy);

      wait.until(
              ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='save']")));
      driver.findElement(By.xpath("//*[text()='Geo Zones']/parent::*")).click();
    }
  }
  }



