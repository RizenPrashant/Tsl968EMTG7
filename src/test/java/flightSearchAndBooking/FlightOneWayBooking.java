package flightSearchAndBooking;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class FlightOneWayBooking extends EaseMyTripBase{
	@Test(priority = 1,description = "To verify Traveller details with valid title,firstName,LastName And phone number")
	public void Book_TC_04() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		webDriver.findElement(By.xpath("//option[@value='Mr']")).click();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys("finch");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='con1']")).click();

		Thread.sleep(5000);
	}
	@Test(priority = 2,description = "To test Book Flight using valid mail id")
	void Book_TC_02() throws IOException, InterruptedException {
		
			FileReader reader = new FileReader("src/main/resources/repo.property");

			Properties p = new Properties();
			p.load(reader);
			String From = p.getProperty("From");
			String To = p.getProperty("To");
			String link = p.getProperty("link");
			webDriver.manage().window().maximize();

			webDriver.get(link);
			webDriver.findElement(By.id("FromSector_show")).clear();

			webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
			webDriver.findElement(By.id("Editbox13_show")).clear();

			webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
			webDriver.findElement(By.id("ddate")).click();
			webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
			//

			Thread.sleep(5000);
//				WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
	//= new WebDriverWait(webDriver, 10);
//				WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//				element1.click();
			webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
					.sendKeys(Keys.ENTER);

			webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
			webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

			webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
			webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		
	}
	@Test(priority = 3,description = "To test Book Flight using invalid mail id")
	void Book_Tc_03() throws InterruptedException, IOException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		WebElement invalid = webDriver.findElement(By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/div[1]/form/div[1]/div[3]/span[2]"));
		String in = invalid.getText();
		assertEquals("Please enter a valid email Id", in);
	
		
	}
	@Test(priority = 4,description = "To Verify Traveller details without details")
	void Book_TC_05() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
		Thread.sleep(3000);
//		webDriver.findElement(By.xpath("//option[@value='Mr']")).click();
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys("finch");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/form/div/div[3]/div[3]/span[2]"));
		String m1 = mob.getText();
		assertEquals("Please enter a valid mobile number", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 5,description = "To Verify Travellrr Detail withoud Entering Title")
	void Book_TC_06() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[1]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//*[@id=\"spanErrorAdult0\"]"));
		String m1 = mob.getText();
		assertEquals("Adult 1 title is required", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 6,description = "To verify Travellor details without Entering First Name")
	void Book_TC_07() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob.getText();
		assertEquals("Adult 1 First Name should have minimum 1", m1);

		Thread.sleep(5000);
	}
	@Test(priority = 7,description = "To verify Travellor Details withoud Entering Last Name")
	void Book_TC_08() throws IOException, InterruptedException {
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.manage().window().maximize();

		webDriver.get(link);
		webDriver.findElement(By.id("FromSector_show")).clear();

		webDriver.findElement(By.id("FromSector_show")).sendKeys(From);
		webDriver.findElement(By.id("Editbox13_show")).clear();

		webDriver.findElement(By.id("Editbox13_show")).sendKeys(To);
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_5_26/11/2021\"]")).click();
		//

		Thread.sleep(5000);
//			WebDriverWait wait1//			webDriver.findElement(By.id("titleAdult4")).click();
//= new WebDriverWait(webDriver, 10);
//			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]")));
//			element1.click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[7]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		webDriver.findElement(By.xpath("//*[@id=\"ResultDiv\"]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.sendKeys(Keys.ENTER);

		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).clear();

		webDriver.findElement(By.xpath("//*[@id=\"txtEmailId\"]")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"spnVerifyEmail\"]")).click();
		Thread.sleep(12000);

		//webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		//webDriver.findElement(By.xpath("//option[@value xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");

		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).clear();
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();//clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");//clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob.getText();
		assertEquals("Adult 1 Last Name should have minimum 1character.", m1);

		Thread.sleep(5000);
	}
}
