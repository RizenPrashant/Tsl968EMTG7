package flightSearchAndBooking;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class FlightRoundTrip extends EaseMyTripBase {
	@Test(priority = 1, description = "Creating acc with valid details")
	public void SearchvalidDetails() throws Exception {

		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		Thread.sleep(5000);

		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("FromSector_show")).clear();
        webDriver.findElement(By.id("FromSector_show")).click();
		webDriver.findElement(By.xpath("//div[@class='search_bg']//li[1]")).click();
		webDriver.findElement(By.id("Editbox13_show")).clear();
        webDriver.findElement(By.id("Editbox13_show")).click();
		webDriver.findElement(By.xpath("//div[@id='toautoFill']//li[2]")).click();
        webDriver.findElement(By.id("ddate")).click();
        webDriver.findElement(By.xpath("//*[@id=\"frth_3_24/11/2021\"]")).click();
        webDriver.findElement(By.id("rdate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_4_25/11/2021\"]")).click();
		Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[5]/div/a/span")).click();
        webDriver.findElement(By.xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[3]/div[1]/div[6]/div/a/span")).click();
		webDriver.findElement(By.xpath("//input[@onclick='SearchFlightWithArmy();']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"DivOut0\"]/div[7]/ul/li/label")).click();
		webDriver.findElement(By.id("BtnBookNow")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"DivMoreFareRT\"]/div/div[3]/a")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divReview\"]/div[15]/div[4]/div[2]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.id(prop.getProperty("idemail"))).sendKeys(prop.getProperty("username"));
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"divTravlerEntry\"]/div[2]/div/a")).click();
		WebElement wb2 = webDriver.findElement(By.id("titleAdult0"));
		Select sc2 = new Select(wb2);
		sc2.selectByVisibleText("MR");
		webDriver.findElement(By.xpath("//input[@id='txtFNAdult0']")).sendKeys(prop.getProperty("name"));
		webDriver.findElement(By.xpath("//input[@id='txtLNAdult0']")).sendKeys(prop.getProperty("lastname"));
		webDriver.findElement(By.id("txtCPhone")).sendKeys(prop.getProperty("no"));
		webDriver.findElement(By.xpath("//*[@id=\"spnTransaction\"]")).click();
	}

	@Test(priority = 2 , description = "Creating acc with Invalid Email")
	public void SearchInvalidEmail() throws Exception {

		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		Thread.sleep(1000);
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).click();
		webDriver.findElement(By.xpath("//div[@class='search_bg']//li[1]")).click();
		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).click();
		webDriver.findElement(By.xpath("//div[@id='toautoFill']//li[2]")).click();
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_3_24/11/2021\"]")).click();
		webDriver.findElement(By.id("rdate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_4_25/11/2021\"]")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[5]/div/a/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[3]/div[1]/div[6]/div/a/span")).click();
		webDriver.findElement(By.xpath("//input[@onclick='SearchFlightWithArmy();']")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//*[@id=\"DivOut0\"]/div[7]/ul/li/label")).click();
		webDriver.findElement(By.id("BtnBookNow")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"DivMoreFareRT\"]/div/div[3]/a")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divReview\"]/div[15]/div[4]/div[2]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.id(prop.getProperty("idemail"))).sendKeys(prop.getProperty("Password1"));
		webDriver.findElement(By.id("spnVerifyEmail")).click();

	}
}