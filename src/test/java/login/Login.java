package login;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class Login extends EaseMyTripBase {
	@Test(priority = 1, description = "Login acc with valid details")
	public void EaswMyTripValidDetails() throws Exception {

		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));//EaseMy Trip url 
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click(); 
		//String email = sh.getRow(2).getCell(0).toString();
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username"));// enter userName
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("xpath"))).sendKeys(prop.getProperty("Password1"));//Enter Password
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click(); // click on login
		System.out.println("LOGIN SUCCEFULLY");// Home page
		

	}

	@Test(priority = 2, description = "Login acc with Inalid Password")
	public void EaswMyTripInValidPassword() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath(prop.getProperty("xpath"))).sendKeys(prop.getProperty("Password2"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("Invalid Password");
	}

	@Test(priority = 3, description = "Login acc with Invalid Email")
	public void EaswMyTripInValidEmail() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		webDriver.findElement(By.id(prop.getProperty("id1"))).sendKeys(prop.getProperty("username1"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		System.out.println("Invalid Email");
		//Thread.sleep(11000);

	}

	@Test(priority = 4, description = "Login acc with Invalid Details")
	public void InvalidDetails() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		System.out.println("Enter valid number and Email");
		//Thread.sleep(11000);
	}

	@Test(priority = 5, description = "Login acc with valid Phone no and valid password")
	public void validPhoneValidPassword() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("username12"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(2500);
		webDriver.findElement(By.xpath("//*[@id=\"shwlgnbx\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("xpath1"))).sendKeys(prop.getProperty("Password12"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("LOGIN SUCCEFULLU");
	}

	@Test(priority = 6, description = "Login acc with valid Phone no and Invalid password")
	public void InValidPassword() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("username12"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"shwlgnbx\"]")).click();
		webDriver.findElement(By.xpath(prop.getProperty("xpath1"))).sendKeys(prop.getProperty("Password13"));
		webDriver.findElement(By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input")).click();
		System.out.println("Invalid Password");

	}

	@Test(priority = 7, description = "Login acc with Invalid Phone no ")
	public void InValidnumber() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.id("spnMyAcc")).click();
		Thread.sleep(500);
		webDriver.findElement(By.id("shwlogn")).click();
		webDriver.findElement(By.id(prop.getProperty("id2"))).sendKeys(prop.getProperty("wrongNumber"));
		webDriver.findElement(By.xpath("//*[@id=\"shwotp\"]")).click();
		//Thread.sleep(11000);
	}
}