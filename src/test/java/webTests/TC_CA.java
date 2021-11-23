package webTests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class TC_CA extends EaseMyTripBase{
	
	@Test(priority=1)
	public void EMTValidEmail() throws Exception {
		//ExtentTest tc1 = ex.createTest("Create account with valid Email");
		Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath(prop.getProperty("MyAccount"))).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("Signup"))).click();
		webDriver.findElement(By.xpath(prop.getProperty("EmailInput"))).sendKeys(prop.getProperty("usernameCA"));
		webDriver.findElement(By.xpath(prop.getProperty("ContinueToOtp"))).click();
		System.out.println("Enter OTP ");
		String otp = s.nextLine();
		webDriver.findElement(By.xpath(prop.getProperty("OtpInput"))).sendKeys(otp);
		webDriver.findElement(By.xpath(prop.getProperty("CreateAcc"))).click();
	}
	
	
	@Test(priority=2)
	public void EMTInValidEmail() throws Exception {
		//ExtentTest tc1 = ex.createTest("Create account with invalid Email");
		//Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='sub_header_link3']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@id='divSignInPnl']/a[@id='shwlogn']")).click();
		webDriver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys(prop.getProperty("wusername"));
		webDriver.findElement(By.xpath("//input[@id='shwotp']")).click();
		String txt = webDriver.findElement(By.id("RegValidEmail")).getText();
		assertEquals("* Enter a valid Email", txt);
		
	}
	
	
	@Test(priority=3)
	public void EMTValidMobNum() throws Exception {
		//ExtentTest tc1 = ex.createTest("Create account with valid Mobile number");
		Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='sub_header_link3']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@id='divSignInPnl']/a[@id='shwlogn']")).click();
		webDriver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("8433044889");
		webDriver.findElement(By.xpath("//input[@id='shwotp']")).click();
		System.out.println("Enter OTP ");
		String otp = s.nextLine();
		//Thread.sleep(5000);
		webDriver.findElement(By.xpath("//input[@id='txtEmail1']")).sendKeys(otp);
		webDriver.findElement(By.xpath("//input[@id='OtpLgnBtn']")).click();
	}
	
	
	@Test(priority=4)
	public void EMTInValidMobNum() throws Exception {
		//ExtentTest tc1 = ex.createTest("Create account with invalid mobile number");
		Scanner s = new Scanner(System.in);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='sub_header_link3']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@id='divSignInPnl']/a[@id='shwlogn']")).click();
		webDriver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("8433044");
		webDriver.findElement(By.xpath("//input[@id='shwotp']")).click();
		String txt = webDriver.findElement(By.id("RegValidPhone")).getText();
		assertEquals("* Enter a valid Phone Number", txt);
	}
	
	
	
	@Test(priority=5)
	public void EMTEmptyUnm() throws Exception {
		//ExtentTest tc1 = ex.createTest("Create account with empty details");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='sub_header_link3']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@id='divSignInPnl']/a[@id='shwlogn']")).click();
		webDriver.findElement(By.xpath("//input[@id='shwotp']")).click();
		String txt = webDriver.findElement(By.xpath("//div[@id='RegValidPhone']")).getText();
		assertEquals("", txt);
	}
	

}
