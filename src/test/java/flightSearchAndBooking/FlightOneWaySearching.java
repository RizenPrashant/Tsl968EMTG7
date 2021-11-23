package flightSearchAndBooking;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class FlightOneWaySearching extends EaseMyTripBase {
	@Test(priority = 1,description = "To Test search flight using valid from City and Destination City and  date ")
	public void Flight_TC_01() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.get(link);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
//

		Thread.sleep(5000);
//		WebDriverWait wait1 = new WebDriverWait(webDriver, 10);
//		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//		element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
	}

	@Test(priority = 2,description = "To Ensure that flights can not be search using the value empty from city, empty Destination City  and date")
	public void Flight_TC_02() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");

		webDriver.manage().window().maximize();

		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(" ");

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert = webDriver.switchTo().alert();
		String popUp = webDriver.switchTo().alert().getText();
		alert.accept();

		assertEquals("Enter valid destination city", popUp);
		System.out.println(popUp);

	}

	@Test(priority = 3,description = " To Ensure that flight can not booked using empty from city ")
	public void Flight_TC_03() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");

		webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		;

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(" ");

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert2 = webDriver.switchTo().alert();
		String popUp2 = webDriver.switchTo().alert().getText();
		alert2.accept();


		assertEquals("Enter valid destination city", popUp2);
		System.out.println(popUp2);
		Thread.sleep(3000);

	}
	@Test(priority = 4,description = "To Ensure that flight can not booked using empty To block ")
	public void Flight_TC_04() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");
		webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		webDriver.findElement(By.id("FromSector_show")).click();

		;

		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);

		Thread.sleep(5000);

		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Alert alert3 = webDriver.switchTo().alert();
		String popUp3 = webDriver.switchTo().alert().getText();
		alert3.accept();


		assertEquals("Enter valid origin city", popUp3);
		System.out.println(popUp3);
		Thread.sleep(3000);

	}
	


	

}
