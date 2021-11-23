package hotelSearchAndBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class HotelBooking extends EaseMyTripBase {

	@Test(priority = 1, description = "invalid case and handling alert")

	public void BookHotel1() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("booking_hotel_01 : To test booking of hotels with entering primary guest details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		//webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout"))).click();
		// rooms & guests
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//div[1]//div[2]//div[1]//div[1]//a[1]//div[5]")).click();
		Thread.sleep(2000);
		String s = webDriver.getWindowHandle();
		Set<String> allWindowHandles = webDriver.getWindowHandles();
		for (String id : allWindowHandles) {
			if (!id.contentEquals(s)) {
				webDriver.switchTo().window(id);
				Thread.sleep(5000);
				webDriver.findElement(
						By.xpath("//div[@class='btnhcol']//a[@class='fill-btn'][normalize-space()='Book Now']"))
						.click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				js.executeScript("window.scrollBy(0,900);");

				webDriver.findElement(By.xpath("//*[@id=\"ddlGender1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).sendKeys("Monty");
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).sendKeys("Sharma");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("monty.sharma@xyz.com");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).clear();
				// driver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).sendKeys("1234567899");
				webDriver.findElement(By.xpath("//*[@id=\"btnTravellerContinue\"]/div[1]")).click();
				Thread.sleep(2000);

				Alert alert = webDriver.switchTo().alert();
				String popUp = webDriver.switchTo().alert().getText();
				alert.accept();
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).sendKeys("1234567899");
				webDriver.findElement(By.xpath("//*[@id=\"btnTravellerContinue\"]/div[1]")).click();

				Thread.sleep(2000);

				js.executeScript("window.scrollBy(0,900);");
				Thread.sleep(4000);
				webDriver.close();
				webDriver.quit();
			}
		}
		Thread.sleep(4000);
		try {
			webDriver.switchTo().window(s);
		} catch (Exception e) {

		}
	}

	@Test(priority = 2, description = "valid test case entering only 1 guest details")
	public void BookHotel2() throws InterruptedException, FileNotFoundException, IOException {
		test = extent.createTest("booking_hotel_02 : To test booking of hotels with entering primary guest details");
		Properties prop = new Properties();
		webDriver.manage().window().maximize();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		// driver.getWindowHandle();
		// driver.getWindowHandles();
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout"))).click();
		// rooms & guests
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		Thread.sleep(7000);
		webDriver.findElement(By.xpath("//div[1]//div[2]//div[1]//div[1]//a[1]//div[5]")).click();
		Thread.sleep(2000);
		String s = webDriver.getWindowHandle();
		Set<String> allWindowHandles = webDriver.getWindowHandles();
		for (String id : allWindowHandles) {
			if (!id.contentEquals(s)) {
				webDriver.switchTo().window(id);
				Thread.sleep(1000);
				webDriver.findElement(
						By.xpath("//div[@class='btnhcol']//a[@class='fill-btn'][normalize-space()='Book Now']"))
						.click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				js.executeScript("window.scrollBy(0,900);");
				webDriver.findElement(By.xpath(prop.getProperty("hfirstname1"))).click();
				webDriver.findElement(By.xpath(prop.getProperty("hfirstname1"))).clear();
				webDriver.findElement(By.xpath(prop.getProperty("hfirstname1"))).sendKeys("alex");
				webDriver.findElement(By.xpath(prop.getProperty("hlastname1"))).click();
				webDriver.findElement(By.xpath(prop.getProperty("hlastname1"))).clear();
				webDriver.findElement(By.xpath(prop.getProperty("hlastname1"))).sendKeys("roy");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath(prop.getProperty("hemailid1"))).click();
				webDriver.findElement(By.xpath(prop.getProperty("hemailid1"))).clear();
				webDriver.findElement(By.xpath(prop.getProperty("hemailid1"))).sendKeys("alex.roy@gmail.com");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath(prop.getProperty("hphone1"))).click();
				webDriver.findElement(By.xpath(prop.getProperty("hphone1"))).clear();
				webDriver.findElement(By.xpath(prop.getProperty("hphone1"))).sendKeys("1234567899");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath(prop.getProperty("hpayment"))).click();

				Thread.sleep(2000);

				js.executeScript("window.scrollBy(0,900);");
				Thread.sleep(4000);
				webDriver.close();
			}
		}
		Thread.sleep(4000);
		try {
			webDriver.switchTo().window(s);
		} catch (Exception e) {

		}
	}

	@Test(priority = 3, description = "1 child and 1 adult valid case")
	public void BookHotel3() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("booking_hotel_03 : To test booking of hotels with entering primary guest details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout"))).click();

		// rooms & guests
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();

		// driver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"divDesc\"]/div[3]/div[2]/div[2]/div[5]/a[2]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();

		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//div[1]//div[2]//div[1]//div[1]//a[1]//div[5]")).click();
		Thread.sleep(2000);
		String s = webDriver.getWindowHandle();
		Set<String> allWindowHandles = webDriver.getWindowHandles();
		for (String id : allWindowHandles) {
			if (!id.contentEquals(s)) {
				webDriver.switchTo().window(id);
				Thread.sleep(5000);
				webDriver.findElement(
						By.xpath("//div[@class='btnhcol']//a[@class='fill-btn'][normalize-space()='Book Now']"))
						.click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				js.executeScript("window.scrollBy(0,900);");
				webDriver.findElement(By.xpath("//*[@id=\"ddlGender1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).sendKeys("Rohan");
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).sendKeys("Naik");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"ddlChildGender\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).sendKeys("Riyansh");
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).sendKeys("Naik");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("rohan.naik@xyz.com");

				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).sendKeys("9765984321");
				webDriver.findElement(By.xpath("//*[@id=\"btnTravellerContinue\"]/div[1]")).click();
				Thread.sleep(2000);

				js.executeScript("window.scrollBy(0,900);");
				Thread.sleep(4000);
				webDriver.close();
			}
		}
		Thread.sleep(4000);
		try {
			webDriver.switchTo().window(s);
		} catch (Exception e) {

		}

	}

	@Test(priority = 4, description = "2 rooms, incomplete details,invalid case not handling alert")
	public void BookHotel4() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("booking_hotel_03 : To test booking of hotels with entering incomplete primary guest details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		//webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();

		// checkout & checkin

		webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[4]/a")).click(); // 19jan
		webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[7]/a")).click(); // 22jan

		// rooms & guests
		webDriver.findElement(By.xpath("//*[@id=\"Adults_room_1_1\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"Child_Age_1_1\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"addhotelRoom\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"Child_Age_1_1\"]")).click();

		webDriver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[4]/input")).click();

		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//div[1]//div[2]//div[1]//div[1]//a[1]//div[5]")).click();
		Thread.sleep(2000);
		String s = webDriver.getWindowHandle();
		Set<String> allWindowHandles = webDriver.getWindowHandles();
		for (String id : allWindowHandles) {
			if (!id.contentEquals(s)) {
				webDriver.switchTo().window(id);
				Thread.sleep(5000);
				webDriver.findElement(
						By.xpath("//div[@class='btnhcol']//a[@class='fill-btn'][normalize-space()='Book Now']"))
						.click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				js.executeScript("window.scrollBy(0,900);");
				webDriver.findElement(By.xpath("//*[@id=\"ddlGender1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstName1\"]")).sendKeys("yasin");
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastName1\"]")).sendKeys("shaikh");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"ddlChildGender\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtFirstNameChild1\"]")).sendKeys("rehan");
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtLastNameChild1\"]")).sendKeys("shaikh");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("yasin.shaikh@xyz.com");

				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).click();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).clear();
				webDriver.findElement(By.xpath("//*[@id=\"txtCPhone\"]")).sendKeys("9765984321");
				Thread.sleep(2000);
				webDriver.findElement(By.xpath("//*[@id=\"btnTravellerContinue\"]/div[1]")).click();
				Thread.sleep(2000);
				Alert alert = webDriver.switchTo().alert();
				String popUp = webDriver.switchTo().alert().getText();
				alert.accept();

				Thread.sleep(2000);

				js.executeScript("window.scrollBy(0,900);");
				Thread.sleep(4000);
				webDriver.close();
			}
		}
		Thread.sleep(4000);
		try {
			webDriver.switchTo().window(s);
		} catch (Exception e) {

		}
	}

}
