package flightSearchAndBooking;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class FBMC_TC extends EaseMyTripBase {
	@Test(priority = 1)
	public void ForValidDetails() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver.findElement(By.xpath("//div[@id=\"ServiceControllerId\"]/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button")).click();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		WebElement ct = webDriver.findElement(By.id("titleAdult0"));
		Select st = new Select(ct);
		st.selectByIndex(1);
		webDriver.findElement(By.name("txtFNAdult0")).sendKeys("Raman");
		webDriver.findElement(By.name("txtLNAdult0")).sendKeys("Taneja");
		webDriver.findElement(By.id("txtCPhone")).sendKeys("8433044889");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
	}
	
	
	@Test(priority = 2)
	public void ForInValidDetails() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver.findElement(By.xpath("//div[@id=\"ServiceControllerId\"]/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button")).click();
		webDriver.findElement(By.id("txtEmailId")).clear();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail");
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		
		
	}
	
	
	@Test(priority = 3)
	public void ForValidDetailsInVPN() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.id("FromSector-mul1_show")).click();
		webDriver.findElement(By.xpath("//div[@id='FromMulti1']//div[2]//div/ul/li[1]")).click();
		webDriver.findElement(By.id("ToSector-mul1_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("FromSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/ul/li[3]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ToSector-mul2_show")).click();
		webDriver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/ul/li[2]/div[1]/span[2]")).click();
		webDriver.findElement(By.id("ddateMul1")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[4]")).click();
		webDriver.findElement(By.id("ddateMul2")).click();
		webDriver.findElement(By.xpath("//tr[4]/td[6]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Thread.sleep(8000);
		webDriver.findElement(By.xpath("//div[@id='ServiceControllerId']/div[6]/div[5]/div[2]/div/div[2]/div/div[2]/button")).click();
		webDriver.findElement(By.id("txtEmailId")).clear();
		webDriver.findElement(By.id("txtEmailId")).sendKeys("cskr342@gmail.com");
		webDriver.findElement(By.id("spnVerifyEmail")).click();
		//webDriver.findElement(By.xpath("//input[@id='chkAdult0']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//label[@id='mycheckbox']/span[2]")).click();
		/*WebElement ct = webDriver.findElement(By.id("titleAdult0"));
		Select st = new Select(ct);
		st.selectByIndex(1);
		webDriver.findElement(By.name("txtFNAdult0")).clear();
		webDriver.findElement(By.name("txtFNAdult0")).sendKeys("Raman");
		webDriver.findElement(By.name("txtLNAdult0")).clear();
		webDriver.findElement(By.name("txtLNAdult0")).sendKeys("Taneja");*/
		webDriver.findElement(By.id("txtCPhone")).clear();
		webDriver.findElement(By.id("txtCPhone")).sendKeys("843304");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
	}
	
	
	@Test(priority = 4)
	public void ForEmptyDetails() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		webDriver.get(prop.getProperty("url"));
		webDriver.findElement(By.xpath("//li[@class='click-mul border-rht mul-hid']")).click();
		webDriver.findElement(By.xpath("//input[@onclick='ValidateMuticity();']")).click();
		Alert al = webDriver.switchTo().alert();
		String txt = al.getText(); // This available in Alert
		al.accept();
		assertEquals("Source cannot be Empty", txt);
	}

}
