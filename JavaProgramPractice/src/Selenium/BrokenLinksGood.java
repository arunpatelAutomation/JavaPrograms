package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksGood {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// Implicit wait for 10 seconds ---dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To launch softwaretestingmaterial.com
		//driver.get("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
		
		driver.get("http://energy.gov/eere/office-energy-efficiency-renewable-energy");
		
		
		//driver.get("https://ctsedwweb.ee.doe.gov/CTSDataAnalysis/Default.aspx?");
		//driver.findElement(By.id("mainContentPlaceHolder_btnOk")).click();
		//Thread.sleep(20000);
		//driver.findElement(By.id("ctl00_contentbody_txtEmailAddress")).sendKeys("arunkumar.patel@ee.doe.gov");
		//driver.findElement(By.id(
		//"ctl00_contentbody_ZMbNOEXnLFIMpoBoGQ1ShzsTJIRKFpxerv2llRbl60uEgvH4PMsjJXQuiLgVMQIhFLDbkx2VRUhlAXK3qDbdhbBWTF5iztPxtvlGQWjN4QpbE0c0w86kFqDZO4T725W"))
		//		.sendKeys("Actionet8");
		//driver.findElement(By.id("ctl00_contentbody_btnLogin")).click();
		// Wait for 5 seconds
		
		//Assert.assertEquals(driver.getTitle(), "CTS: Home Page");
		// 1. get the list of all the links and images:
		List<WebElement> allPageLinks = driver.findElements(By.tagName("a"));
		//links.addAll(driver.findElements(By.tagName("img")));
				// To print the total number of links
		System.out.println("Total Number od links URL are =====>" +allPageLinks.size());
	
		
		for(int i=0; i<allPageLinks.size();i++) {
			WebElement pageLink = allPageLinks.get(i);
			String pageUrl = pageLink.getAttribute("href");
			
			int responseCode;
			
			URL link = new URL(pageUrl);
		
		
		HttpURLConnection httpConnection = (HttpURLConnection) link.openConnection();
		
		httpConnection.connect();
		
		responseCode =  httpConnection.getResponseCode();
		
		if(responseCode>=400) {
			System.out.println(responseCode+" - "+pageUrl+" - is Broken Link");
			}else {
			System.out.println(responseCode+" - "+pageUrl+" - Valid Link");
		}
		
		
		}
		//driver.close();
	}

}
