package hotelSearchAndBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webTests.EaseMyTripBase;

public class HotelSearch extends EaseMyTripBase {
	 @Test(priority=1)
  public void searchhotel1() throws FileNotFoundException, IOException {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/main/resources/repo.property"));
	  webDriver.get(prop.getProperty("url"));
	  webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
	  webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
	
		//checkout & checkin
		
	  webDriver.findElement(By.xpath(prop.getProperty("checkin"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("checkout"))).click();
	    
		//rooms & guests
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
	 }  

	 @Test(priority=2 , description ="no location" , dependsOnMethods="searchhotel1")
  public void searchhotel2() throws FileNotFoundException, IOException, Exception {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/main/resources/repo.property"));
	  webDriver.get(prop.getProperty("url"));
		  
	  webDriver.findElement(By.xpath(prop.getProperty("hotel1"))).click();
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath(prop.getProperty("hotelloc"))).click();
		  //driver.findElement(By.xpath("//div[@class='htl_location']")).clear();
		
		//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity1"))).clear();
		
		//checkout & checkin
	  webDriver.findElement(By.xpath(prop.getProperty("date"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("checkin1"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("checkout1"))).click();
	    
		//rooms & guests
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	 }
	//Alert alert = driver.switchTo().alert();
		//String popUp = driver.switchTo().alert().getText();
		//alert.accept();
	
/* driver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
		driver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
	driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[4]/input")).click(); 
	
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[6]/a")).click();
	
	driver.findElement(By.xpath("//*[@id=\"Adults_room_1_1\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"addhotelRoom\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();   */
	
//	driver.findElement(By.xpath(prop.getProperty("search"))).click(); 
 // } 

  @Test(priority=3, description= "checkin and checkout with same date" , dependsOnMethods="searchhotel2" )
  public void searchhotel3() throws FileNotFoundException, IOException, Exception {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/main/resources/repo.property"));
	  webDriver.get(prop.getProperty("url"));
	  webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
	  Thread.sleep(1000);
	  webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
	  webDriver.findElement(By.xpath(prop.getProperty("txtcityop1"))).click();
		//checkout & checkin
	  webDriver.findElement(By.xpath(prop.getProperty("checkin2"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("checkout2"))).click();
	    
		//rooms & guests
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		
	  Alert alert = webDriver.switchTo().alert();
	  String popUp2 = webDriver.switchTo().alert().getText();
	  alert.accept(); 
  
	  webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
	  webDriver.findElement(By.xpath(prop.getProperty("txtcityop1"))).click();
	
	  webDriver.findElement(By.xpath(prop.getProperty("newcheckin2"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("newcheckout2"))).click();
		
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("search"))).click(); 
		
  } 
  
  @Test(priority=4, description= "4 adults and 2 children in 2 rooms" , dependsOnMethods="searchhotel3")  
  public void searchhotel4() throws FileNotFoundException, IOException, InterruptedException {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/main/resources/repo.property"));
	  webDriver.get(prop.getProperty("url"));
	  webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
			//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("goa,india");
	  webDriver.findElement(By.xpath(prop.getProperty("txtcityop"))).click();
		
		//checkout & checkin
	  webDriver.findElement(By.xpath(prop.getProperty("checkin3"))).click(); //8jan
	  webDriver.findElement(By.xpath(prop.getProperty("checkout3"))).click(); //15jan
		//rooms & guests
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
	  webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
	  webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		
	  webDriver.findElement(By.xpath(prop.getProperty("bookroom"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		 Thread.sleep(5000);
  }
 
  @Test(priority=5 , description= "8 adults and 2 children in 3 rooms" , dependsOnMethods="searchhotel4" )
  public void searchhotel5() throws FileNotFoundException, IOException, InterruptedException {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/main/resources/repo.property"));
	  webDriver.get(prop.getProperty("url"));
	  webDriver.findElement(By.xpath(prop.getProperty("hotels"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("city"))).click();
		//location and city
	  webDriver.findElement(By.xpath(prop.getProperty("txtcity"))).sendKeys("new delhi,india");
	  webDriver.findElement(By.xpath(prop.getProperty("txtcityop3"))).click();
		
		
		//checkout & checkin
	  webDriver.findElement(By.xpath(prop.getProperty("checkin5"))).click();
	  webDriver.findElement(By.xpath(prop.getProperty("checkout5"))).click();
	    
		//rooms & guests //6 adults and 2 children in 3 rooms
	  webDriver.findElement(By.xpath(prop.getProperty("room"))).click();
	  webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"Child_Age_1_1\"]")).click();
	  webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
	  webDriver.findElement(By.xpath("//*[@id=\"Children_room_1_1_plus\"]")).click();
	  webDriver.findElement(By.xpath(prop.getProperty("roomadd"))).click();
		
		
	  webDriver.findElement(By.xpath("//*[@id=\"exithotelroom\"]")).click();
	  webDriver.findElement(By.xpath(prop.getProperty("search"))).click();
		 Thread.sleep(2000); 
  }
 
}
