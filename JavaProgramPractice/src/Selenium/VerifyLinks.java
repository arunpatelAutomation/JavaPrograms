package Selenium;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To launch softwaretestingmaterial.com
		driver.get("http://energy.gov/eere/office-energy-efficiency-renewable-energy");
		//driver.get("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
		//driver.findElement(By.id("ctl00_contentbody_txtEmailAddress")).sendKeys("arunkumar.patel@ee.doe.gov");
	//	driver.findElement(By.id(
		//		"ctl00_contentbody_ZMbNOEXnLFIMpoBoGQ1ShzsTJIRKFpxerv2llRbl60uEgvH4PMsjJXQuiLgVMQIhFLDbkx2VRUhlAXK3qDbdhbBWTF5iztPxtvlGQWjN4QpbE0c0w86kFqDZO4T725W"))
		//		.sendKeys("Actionet9988");
		//driver.findElement(By.id("ctl00_contentbody_btnLogin")).click();
		// Wait for 5 seconds
		Thread.sleep(5000);
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}
		
	}
	
	public static void verifyLinkActive(String urlLink)
	{
        try 
        {
           URL url = new URL(urlLink);
           
           HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
           
           httpConn.setConnectTimeout(3000);
           
           httpConn.connect();
           
           if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 400) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 500) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
		} catch (Exception e) {
           
        }
    } 
	
	
	 
 
}