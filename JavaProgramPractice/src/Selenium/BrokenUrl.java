package Selenium;

	import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit; 
	import java.util.ArrayList;
	 
	import java.util.HashSet;
	 
	import java.util.Iterator;
	 
	import java.util.NoSuchElementException;
	 
	import java.util.Set;
	 
	import org.openqa.selenium.By;
	 
	import org.openqa.selenium.JavascriptExecutor;
	 
	import org.openqa.selenium.Keys;
	 
	import org.openqa.selenium.WebDriver;
	 
	import org.openqa.selenium.WebDriver.Navigation;
	 
	import org.openqa.selenium.WebDriver.Options;
	 
	import org.openqa.selenium.WebElement;
	 
	import org.openqa.selenium.chrome.ChromeDriver;
	 
	import org.openqa.selenium.support.ui.*;
	 
	import com.google.common.base.Function;
	 
	import com.google.common.base.Predicate;
	 
	
	 
	//import org.openqa.selenium.*;
	 
	//import org.openqa.selenium.firefox.*;
	 
	public class BrokenUrl {
	 
	  public static List findAllLinks(WebDriver driver)
	 
	  {
	 
	   List<WebElement> elementList = new ArrayList();
	 
	   elementList = driver.findElements(By.tagName("a"));
	 
	   elementList.addAll(driver.findElements(By.tagName("img")));
	 
	   List finalList = new ArrayList(); ;
	 
	   for (WebElement element : elementList)
	 
	   {
	 
	   if(element.getAttribute("href") != null)
	 
	   {
	 
	   finalList.add(element);
	 
	   }   
	 
	   } 
	 
	   return finalList;
	 
	  }
	 
	 public static String isLinkBroken(URL url) throws Exception
	 
	 {
	 
	 url = new URL("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
	 
	 String response = "";
	 
	 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 
	 try
	 
	 {
	 
	     connection.connect();
	 
	      response = connection.getResponseMessage();         
	 
	     connection.disconnect();
	 
	     return response;
	 
	 }
	 
	 catch(Exception exp)
	 
	 {
	 
	 return exp.getMessage();
	 
	 }   
	 
	 }
	 
	 public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			// Maximize the browser
			driver.manage().window().maximize();
			// Implicit wait for 10 seconds ---dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// To launch softwaretestingmaterial.com
			driver.get("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
			
			//driver.get("http://energy.gov/eere/office-energy-efficiency-renewable-energy");
			//driver.findElement(By.id("mainContentPlaceHolder_btnOk")).click();
			driver.findElement(By.id("ctl00_contentbody_txtEmailAddress")).sendKeys("arunkumar.patel@ee.doe.gov");
			driver.findElement(By.id(
					"ctl00_contentbody_ZMbNOEXnLFIMpoBoGQ1ShzsTJIRKFpxerv2llRbl60uEgvH4PMsjJXQuiLgVMQIhFLDbkx2VRUhlAXK3qDbdhbBWTF5iztPxtvlGQWjN4QpbE0c0w86kFqDZO4T725W"))
					.sendKeys("Actionet9988");
			driver.findElement(By.id("ctl00_contentbody_btnLogin")).click();
			// Wait for 5 seconds
			Thread.sleep(5000);
	 
	 	 //ff.get("http://www.yahoo.com/");     
	 
	     List<WebElement> allImages = findAllLinks(driver);    
	 
	     System.out.println("Total number of elements found " + allImages.size());
	 
	     for( WebElement element : allImages){
	 
	      try
	 
	      {
	 
	         System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
	 
	    System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
	 
	      }
	 
	      catch(Exception exp)
	 
	      {
	 
	      System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());      
	 
	      }
	 
	     }
	 
	     }
	 
	 }