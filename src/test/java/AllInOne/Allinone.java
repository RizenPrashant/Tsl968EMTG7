package AllInOne;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import login.Login;
import webTests.EaseMyTripBase;

public class Allinone extends EaseMyTripBase {
	// Create
	@Test(priority = 1)
	public void EMTValidEmail() throws Exception {
		test = extent.createTest("SignUp_TC_01 : To Test SignUp with Valid Email");
		// ExtentTest tc1 = ex.createTest("Create account with valid Email");
		Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		test.info("Click on My Account ");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).sendKeys(prop.getProperty("usernameCA"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath(prop.getProperty("ContinueToOtp"))).click();
		test.info("Click on continue");
		System.out.println("Enter OTP ");
		String otp = s.nextLine();
		webDriver.findElement(By.xpath(prop.getProperty("OtpInput"))).sendKeys(otp);
		test.info("Enter OTP");
		webDriver.findElement(By.xpath(prop.getProperty("CreateAcc"))).click();
		test.pass("SignUp_TC_01 completed");
	}

	@Test(priority = 2)
	public void EMTInValidEmail() throws Exception {
		test = extent.createTest("SignUp_TC_02 : To Test SignUp with InValid Email");
		// ExtentTest tc1 = ex.createTest("Create account with invalid Email");
		// Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		test.info("Click on My Account ");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).sendKeys(prop.getProperty("wusername"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath(prop.getProperty("ContinueToOtp"))).click();
		test.info("Click on continue");
		String txt = webDriver.findElement(By.id("RegValidEmail")).getText();
		assertEquals("* Enter a valid Email", txt);
		test.pass("SignUp_TC_02 completed");
	}

	@Test(priority = 3)
	public void EMTValidMobNum() throws Exception {
		test = extent.createTest("SignUp_TC_03 : To Test SignUp with valid mobile number");
		// ExtentTest tc1 = ex.createTest("Create account with valid Mobile number");
		Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		test.info("Click on My Account ");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).sendKeys(prop.getProperty("username12"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath(prop.getProperty("ContinueToOtp"))).click();
		test.info("Click on continue");
		System.out.println("Enter OTP ");
		String otp = s.nextLine();
		// Thread.sleep(5000);
		webDriver.findElement(By.xpath(prop.getProperty("OtpInput"))).sendKeys(otp);
		test.info("Enter OTP");
		webDriver.findElement(By.xpath("//input[@id='OtpLgnBtn']")).click();
		test.pass("SignUp_TC_03 completed");
	}

	@Test(priority = 4)
	public void EMTInValidMobNum() throws Exception {
		test = extent.createTest("SignUp_TC_04 : To Test SignUp with valid mobile number");
		// ExtentTest tc1 = ex.createTest("Create account with invalid mobile number");
		// Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		test.info("Click on My Account ");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).sendKeys(prop.getProperty("wrongNumber"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath(prop.getProperty("ContinueToOtp"))).click();
		test.info("Click on continue");
		String txt = webDriver.findElement(By.id("RegValidPhone")).getText();
		assertEquals("* Enter a valid Phone Number", txt);
		test.pass("SignUp_TC_04 completed");
	}

	@Test(priority = 5)
	public void EMTEmptyUnm() throws Exception {
		test = extent.createTest("SignUp_TC_04 : To Test SignUp with empty details");
		// ExtentTest tc1 = ex.createTest("Create account with empty details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		test.info("Click on My Account ");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).click();
		test.info("Click on continue");
		String txt = webDriver.findElement(By.xpath("//div[@id='RegValidPhone']")).getText();
		assertEquals("", txt);
		test.pass("SignUp_TC_05 completed");
	}

	// Login
	@Test(priority = 6, description = "Login acc with valid details")
	public void EaswMyTripValidDetails() throws Exception {
		test = extent.createTest("tc_login01 :o check login feature with valid Email Id and valid password");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));// EaseMy Trip url
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		// String email = sh.getRow(2).getCell(0).toString();
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username"));// enter userName
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(2000);
		test.info("Click on continue");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath(prop.getProperty("xpath"))).sendKeys(prop.getProperty("Password1"));// Enter
																											// Password
		test.info("Enter Password");
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click(); // click on
																											// login
		System.out.println("LOGIN SUCCEFULLY");// Home page
		test.pass("tc_login01 completed");

	}

	@Test(priority = 7, description = "Login acc with Inalid Password")
	public void EaswMyTripInValidPassword() throws Exception {
		test = extent.createTest("tc_login02 :to check login feature with valid Email and invalid password");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		test.info("opening Browser");
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath(prop.getProperty("xpath"))).sendKeys(prop.getProperty("Password2"));
		test.info("Enter Password");
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("Invalid Password");
	}

	@Test(priority = 8, description = "Login acc with Invalid Email")
	public void EaswMyTripInValidEmail() throws Exception {
		test = extent.createTest("tc_login03 : to check with invalid Email ");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username1"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		System.out.println("Invalid Email");
		// Thread.sleep(11000);

	}

	@Test(priority = 9, description = "Login acc with Invalid Details")
	public void InvalidDetails() throws Exception {
		test = extent.createTest("tc_login04 :to check with valid phone no and valid password");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		System.out.println("Enter valid number and Email");
		// Thread.sleep(11000);
	}

	@Test(priority = 10, description = "Login acc with valid Phone no and valid password")
	public void validPhoneValidPassword() throws Exception {
		test = extent.createTest("tc_login05 :to check with valid phone no and Invalid password");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("username12"));
		test.info("Enter UserName ");
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		test.info("Click on continue");
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//a[@id='shwlgnbx']")).click();
		webDriver.findElement(By.xpath(prop.getProperty("xpath1"))).sendKeys(prop.getProperty("Password12"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("LOGIN SUCCEFULLU");
	}

	@Test(priority = 11, description = "Login acc with valid Phone no and Invalid password")
	public void InValidPassword() throws Exception {
		test = extent.createTest("tc_login06 :to check with Invalid phone number");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("username12"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		test.info("Click on continue");
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//a[@id='shwlgnbx']")).click();
		webDriver.findElement(By.xpath(prop.getProperty("xpath1"))).sendKeys(prop.getProperty("Password13"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("Invalid Password");

	}

	@Test(priority = 12, description = "Login acc with Invalid Phone no ")
	public void InValidnumber() throws Exception {
		test = extent.createTest("tc_login07 :to check login feature without Enter Email Or Phone Number ");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("wrongNumber"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		test.info("Click on continue");
		System.out.println("Invalid phone number");
		// Thread.sleep(11000);
	}

	@Test(enabled = true, priority = 13, description = "to show screenshot in extent report.")
	public void EaswMyTripValidDetailsToFailTest() throws Exception {
		test = extent.createTest("tc_login08 : to check login feature for screenshot");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));// EaseMy Trip url
		test.info("opening Browser");
		webDriver.findElement(By.id("spnMyAcc")).click();
		test.info("Click on My Account ");
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		test.info("Click on login or SignUp ");
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username"));// enter userName
		//Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"shwotpms\"]")).click(); // to show screenshoot of failed test cases
		test.info("Click on continue");
		Thread.sleep(11000);
		webDriver.findElement(By.xpath(prop.getProperty("xpath"))).sendKeys(prop.getProperty("Password1"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click(); // click on
		System.out.println("LOGIN SUCCESSFULLY");
	}

	// FlightOneWaySearching
	@Test(priority = 14, description = "To Test search flight using valid from City and Destination City and  date ")
	public void Flight_TC_01() throws IOException, InterruptedException {
		test = extent.createTest(
				"Flight_TC_01 :To Test search flight using valid from City and Destination City and  date ");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		webDriver.get(link);
		// webDriver.manage().window().maximize();
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

	@Test(priority = 15, description = "To Ensure that flights can not be search using the value empty from city, empty Destination City  and date")
	public void Flight_TC_02() throws IOException, InterruptedException {
		test = extent.createTest(
				"Flight_TC_02 :To Ensure that flights can not be search using the value empty from city, empty Destination City  and date");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");

		// webDriver.manage().window().maximize();

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

	@Test(priority = 16, description = " To Ensure that flight can not booked using empty from city ")
	public void Flight_TC_03() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_03 :To Ensure that flight can not booked using empty from city ");

		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");

		// webDriver.manage().window().maximize();
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

	@Test(priority = 17, description = "To Ensure that flight can not booked using empty To block ")
	public void Flight_TC_04() throws IOException, InterruptedException {
		test = extent.createTest("Flight_TC_04 :To Ensure that flight can not booked using empty To block ");

		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String link = p.getProperty("link");
		String To = p.getProperty("To");
		String From = p.getProperty("From");
		// webDriver.manage().window().maximize();
		webDriver.get(link);

		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).sendKeys(" ");
		webDriver.findElement(By.id("FromSector_show")).click();
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

	// FlightOneWayBooking
	@Test(priority = 18, description = "To verify Traveller details with valid title,firstName,LastName And phone number")
	public void Book_TC_04() throws IOException, InterruptedException {
		test = extent.createTest(
				"Book_TC_04:To verify Traveller details with valid title,firstName,LastName And phone number");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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

	@Test(priority = 19, description = "To test Book Flight using valid mail id")
	void Book_TC_02() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_02: To test Book Flight using valid mail id");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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
		// = new WebDriverWait(webDriver, 10);
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

	@Test(priority = 20, description = "To test Book Flight using invalid mail id")
	void Book_Tc_03() throws InterruptedException, IOException {
		test = extent.createTest("Book_TC_03: To test Book Flight using invalid mail id");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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
		WebElement invalid = webDriver.findElement(
				By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/div[1]/form/div[1]/div[3]/span[2]"));
		String in = invalid.getText();
		assertEquals("Please enter a valid email Id", in);

	}

	@Test(priority = 21, description = "To Verify Traveller details without details")
	void Book_TC_05() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_05: To Verify Traveller details without details");
		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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
		// webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
		Thread.sleep(3000);
//		webDriver.findElement(By.xpath("//option[@value='Mr']")).click();
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");
//		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys("finch");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();// clear phone no
		// Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(
				By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/form/div/div[3]/div[3]/span[2]"));
		String m1 = mob.getText();
		assertEquals("Please enter a valid mobile number", m1);

		Thread.sleep(5000);
	}

	@Test(priority = 22, description = "To Verify Travellrr Detail withoud Entering Title")
	void Book_TC_06() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_06: To Verify Travellrr Detail withoud Entering Title");

		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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

		// webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[1]")).click();
		// webDriver.findElement(By.xpath("//option[@value
		// xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();// clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");// clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//*[@id=\"spanErrorAdult0\"]"));
		String m1 = mob.getText();
		assertEquals("Adult 1 title is required", m1);

		Thread.sleep(5000);
	}

	@Test(priority = 23, description = "To verify Travellor details without Entering First Name")
	void Book_TC_07() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_07: To verify Travellor details without Entering First Name");

		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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

		// webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		// webDriver.findElement(By.xpath("//option[@value
		// xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(" ");
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();// clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");// clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob.getText();
		assertEquals("Adult 1 First Name should have minimum 1", m1);

		Thread.sleep(5000);
	}

	@Test(priority = 24, description = "To verify Travellor Details withoud Entering Last Name")
	void Book_TC_08() throws IOException, InterruptedException {
		test = extent.createTest("Book_TC_08: To verify Travellor Details withoud Entering Last Name");

		FileReader reader = new FileReader("src/main/resources/repo.property");

		Properties p = new Properties();
		p.load(reader);
		String From = p.getProperty("From");
		String To = p.getProperty("To");
		String link = p.getProperty("link");
		// webDriver.manage().window().maximize();

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

		// webDriver.findElement(By.xpath("//a[@class='add_adlt']")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titleAdult1\"]")));
//		Select drpdwn = new Select(webDriver.findElement(By.xpath("//*[@id=\"titleAdult1\"]")));
//		drpdwn.deselectAll();
		webDriver.findElement(By.xpath("//*[@id=\"mycheckbox\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"titleAdult0\"]/option[2]")).click();
		// webDriver.findElement(By.xpath("//option[@value
		// xpath='1']")).click();//clicking Title option
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).clear();
		webDriver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys("aron");

		webDriver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).clear();
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).clear();// clear phone no
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("9021691623");// clear phone no

		webDriver.findElement(By.xpath("//div[@class='con1']")).click();
		WebElement mob = webDriver.findElement(By.xpath("//span[@id='spanErrorAdult0']"));
		String m1 = mob.getText();
		assertEquals("Adult 1 Last Name should have minimum 1character.", m1);

		Thread.sleep(5000);
	}

	// FlightRoundTripBooking
	@Test(priority = 25, description = "Creating acc with valid details")
	public void SearchvalidDetails() throws Exception {
		test = extent.createTest(
				"tc_roundTrip_01 :to Search  and book Flight For RoundTrip with valid details and valid email");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		Thread.sleep(5000);
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).click();
		test.info("select departure ");
		webDriver.findElement(By.xpath("//div[@class='search_bg']//li[1]")).click();
		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).click();
		webDriver.findElement(By.xpath("//div[@id='toautoFill']//li[2]")).click();
		test.info("select Arrival ");
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_3_24/11/2021\"]")).click();
		test.info("select departure date ");
		webDriver.findElement(By.id("rdate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_4_25/11/2021\"]")).click();
		test.info("select return date ");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[5]/div/a/span")).click();
		test.info("select traveler ");
		webDriver.findElement(By.xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[3]/div[1]/div[6]/div/a/span")).click();
		test.info("select class ");
		webDriver.findElement(By.xpath("//input[@onclick='SearchFlightWithArmy();']")).click();
		Thread.sleep(2000);
		test.info("click on search button");
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"DivOut0\"]/div[7]/ul/li/label")).click();
		webDriver.findElement(By.id("BtnBookNow")).click();
		test.info("click on book now");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"DivMoreFareRT\"]/div/div[3]/a")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divReview\"]/div[15]/div[4]/div[2]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.id(prop.getProperty("idemail"))).sendKeys(prop.getProperty("username"));
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		test.info("click on continue");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id='divTravlerEntry']/div[2]/div/a")).click();
		Thread.sleep(1000);
		WebElement wb2 = webDriver.findElement(By.id("titleAdult0"));
		Select sc2 = new Select(wb2);
		sc2.selectByVisibleText("MR");
		test.info("select Title");
		webDriver.findElement(By.xpath("//input[@id='txtFNAdult0']")).sendKeys(prop.getProperty("name"));
		test.info("Enter First Name");
		webDriver.findElement(By.xpath("//input[@id='txtLNAdult0']")).sendKeys(prop.getProperty("lastname"));
		test.info("enter last name");
		webDriver.findElement(By.id("txtCPhone")).sendKeys(prop.getProperty("no"));
		webDriver.findElement(By.xpath("//*[@id=\"spnTransaction\"]")).click();
	}

	@Test(priority = 26, description = "Creating acc with Invalid Email")
	public void SearchInvalidEmail() throws Exception {
		test = extent.createTest(
				"tc_roundTrip_02 :to Search  and book Flight For RoundTrip with valid details and Invalid email");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		Thread.sleep(1000);
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.id("FromSector_show")).clear();
		webDriver.findElement(By.id("FromSector_show")).click();
		test.info("select departure ");
		webDriver.findElement(By.xpath("//div[@class='search_bg']//li[1]")).click();
		webDriver.findElement(By.id("Editbox13_show")).clear();
		webDriver.findElement(By.id("Editbox13_show")).click();
		webDriver.findElement(By.xpath("//div[@id='toautoFill']//li[2]")).click();
		test.info("select Arrival ");
		webDriver.findElement(By.id("ddate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_3_24/11/2021\"]")).click();
		test.info("select departure date ");
		webDriver.findElement(By.id("rdate")).click();
		webDriver.findElement(By.xpath("//*[@id=\"frth_4_25/11/2021\"]")).click();
		test.info("select return date ");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[1]/div[5]/div/a/span")).click();
		test.info("select traveler ");
		webDriver.findElement(By.xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[3]/div[1]/div[6]/div/a/span")).click();
		test.info("select class ");
		webDriver.findElement(By.xpath("//input[@onclick='SearchFlightWithArmy();']")).click();
		test.info("click on search");
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("//*[@id=\"DivOut0\"]/div[7]/ul/li/label")).click();
		webDriver.findElement(By.id("BtnBookNow")).click();
		test.info("click on book now");
		Thread.sleep(35000);
		webDriver.findElement(By.xpath("//*[@id=\"DivMoreFareRT\"]/div/div[3]/a")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divReview\"]/div[15]/div[4]/div[2]/label/span")).click();
		webDriver.findElement(By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[3]/label/span")).click();
		webDriver.findElement(By.id(prop.getProperty("idemail"))).sendKeys(prop.getProperty("Password1"));
		webDriver.findElement(By.id("spnVerifyEmail")).click();

	}

	// FlightMultiCityBooking
	@Test(priority = 27)
	public void ForValidDetails() throws Exception {
		test = extent.createTest(
				"FBMC_TC_01 : To test search page for Two Departure and Two destination Cities with valid email");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver
				.findElement(By
						.xpath("//div[@id=\"ServiceControllerId\"]/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button"))
				.click();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		Thread.sleep(2000);
		WebElement ct = webDriver.findElement(By.xpath("//select[@id='titleAdult0']"));
		Select st = new Select(ct);
		st.selectByIndex(2);
		webDriver.findElement(By.name("txtFNAdult0")).sendKeys("Raman");
		Thread.sleep(500);
		webDriver.findElement(By.name("txtLNAdult0")).sendKeys("Taneja");
		webDriver.findElement(By.id("txtCPhone")).sendKeys("8433044889");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
	}

	@Test(priority = 28)
	public void ForInValidDetails() throws Exception {
		test = extent.createTest(
				"FBMC_TC_03 : To test search page for Two Departure and Two destination Cities with invalid email");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver
				.findElement(By
						.xpath("//div[@id=\"ServiceControllerId\"]/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button"))
				.click();
		webDriver.findElement(By.id("txtEmailId")).clear();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail");
		webDriver.findElement(By.id("spnVerifyEmail")).click();

	}

	@Test(priority = 29)
	public void ForValidDetailsInVPN() throws Exception {
		test = extent.createTest("FBMC_TC_04 : To test search page with valid details and invalid phone number");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath(
				"/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]"))
				.click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver
				.findElement(
						By.xpath("//div[@id='ServiceControllerId']/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button"))
				.click();
		webDriver.findElement(By.id("txtEmailId")).clear();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		// webDriver.findElement(By.xpath("//input[@id='chkAdult0']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//label[@id='mycheckbox']/span[2]")).click();
		/*
		 * WebElement ct = webDriver.findElement(By.id("titleAdult0")); Select st = new
		 * Select(ct); st.selectByIndex(1);
		 * webDriver.findElement(By.name("txtFNAdult0")).clear();
		 * webDriver.findElement(By.name("txtFNAdult0")).sendKeys("Raman");
		 * webDriver.findElement(By.name("txtLNAdult0")).clear();
		 * webDriver.findElement(By.name("txtLNAdult0")).sendKeys("Taneja");
		 */
		webDriver.findElement(By.id("txtCPhone")).clear();
		webDriver.findElement(By.id("txtCPhone")).sendKeys("843304");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
	}

	@Test(priority = 30)
	public void ForEmptyDetails() throws Exception {
		test = extent.createTest("FBMC_TC_03 : To test search page for empty cities field");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		test.info("opening Browser");
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Alert al = webDriver.switchTo().alert();
		String txt = al.getText(); // This available in Alert
		al.accept();
		assertEquals("Source cannot be Empty", txt);
	}

	// HotelSearching
	@Test(priority = 31)
	public void searchhotel1() throws FileNotFoundException, IOException {
		test = extent.createTest(
				"search_hotel_01 : To test search hotels with City name, Location or Specific hotel,check in,check out and rooms/guests");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
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
	}

	@Test(priority = 32, description = "no location", dependsOnMethods = "searchhotel1")
	public void searchhotel2() throws FileNotFoundException, IOException, Exception {
		test = extent.createTest(
				"search_hotel_02 :To test search hotels without entering City name, Location or Specific hotel");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));

		webDriver.findElement(By.xpath(prop.getProperty("hotel1"))).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath(prop.getProperty("hotelloc"))).click();
		// driver.findElement(By.xpath("//div[@class='htl_location']")).clear();

		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity1"))).clear();

		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("date"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkin1"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout1"))).click();

		// rooms & guests
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	}
	// Alert alert = driver.switchTo().alert();
	// String popUp = driver.switchTo().alert().getText();
	// alert.accept();

	/*
	 * driver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys(
	 * "goa,india");
	 * driver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
	 * driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[4]/input"))
	 * .click();
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[2]/a")).click();
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[6]/a")).click();
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"Adults_room_1_1\"]")).click();
	 * driver.findElement(By.xpath("//*[@id=\"addhotelRoom\"]")).click();
	 * driver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();
	 */

//		driver.findElement(By.xpath(prop.getProperty("search"))).click(); 
	// }

	@Test(priority = 33, description = "checkin and checkout with same date", dependsOnMethods = "searchhotel2")
	public void searchhotel3() throws FileNotFoundException, IOException, Exception {
		test = extent.createTest("search_hotel_03 : To test search hotels without entering check in option");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop1"))).click();
		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin2"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout2"))).click();

		// rooms & guests
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();

		Alert alert = webDriver.switchTo().alert();
		String popUp2 = webDriver.switchTo().alert().getText();
		alert.accept();

		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop1"))).click();

		webDriver.findElement(By.xpath(prop.getProperty("newcheckin2"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("newcheckout2"))).click();

		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();

	}

	@Test(priority = 34, description = "4 adults and 2 children in 2 rooms", dependsOnMethods = "searchhotel3")
	public void searchhotel4() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("search_hotel_04 : To test search hotels without entering check in option");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();

		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin3"))).click(); // 8jan
		webDriver.findElement(By.xpath(prop.getProperty("checkout3"))).click(); // 15jan
		// rooms & guests
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();

		webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		Thread.sleep(5000);
	}

	@Test(priority = 35, description = "8 adults and 2 children in 3 rooms", dependsOnMethods = "searchhotel4")
	public void searchhotel5() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("search_hotel_05 : To test search hotels without entering check in option");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		// location and city
		webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
		webDriver.findElement(By.xpath(prop.getProperty("txtcityop3"))).click();

		// checkout & checkin
		webDriver.findElement(By.xpath(prop.getProperty("checkin5"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("checkout5"))).click();

		// rooms & guests //6 adults and 2 children in 3 rooms
		webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"Child_Age_1_1\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
		webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();

		webDriver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		Thread.sleep(2000);
	}

	// Booking Hotel
	@Test(priority = 36, description = "invalid case and handling alert")

	public void BookHotel1() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("booking_hotel_01 : To test booking of hotels with entering primary guest details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		// webDriver.manage().window().maximize();
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
				webDriver
						.findElement(
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
			}
		}
		Thread.sleep(4000);
		try {
			webDriver.switchTo().window(s);
		} catch (Exception e) {

		}
	}

	@Test(priority = 37, description = "valid test case entering only 1 guest details")
	public void BookHotel2() throws InterruptedException, FileNotFoundException, IOException {
		test = extent.createTest("booking_hotel_02 : To test booking of hotels with entering primary guest details");
		Properties prop = new Properties();
		//webDriver.manage().window().maximize();
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
				webDriver
						.findElement(
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

	@Test(priority = 38, description = "1 child and 1 adult valid case")
	public void BookHotel3() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest("booking_hotel_03 : To test booking of hotels with entering primary guest details");
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
				webDriver
						.findElement(
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

	@Test(priority = 39, description = "2 rooms, incomplete details,invalid case not handling alert")
	public void BookHotel4() throws FileNotFoundException, IOException, InterruptedException {
		test = extent.createTest(
				"booking_hotel_03 : To test booking of hotels with entering incomplete primary guest details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		// webDriver.manage().window().maximize();
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
				webDriver
						.findElement(
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
