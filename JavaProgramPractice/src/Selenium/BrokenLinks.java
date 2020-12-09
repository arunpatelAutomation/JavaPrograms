package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrokenLinks {

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
		Thread.sleep(25000);
		Assert.assertEquals(driver.getTitle(), "CTS: Home Page");
		// 1. get the list of all the links and images:
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//links.addAll(driver.findElements(By.tagName("img")));
				// To print the total number of links
		System.out.println("Total links and Images are =====>" + links.size());
		
		/* List<WebElement> activelinks = new ArrayList<WebElement>();
		
		//2. itrate linklist : exclude all the links/images - doesn't have href attribute
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getAttribute("href"));
			if((links.get(i).getAttribute("href")!=null) && (links.get(i).getAttribute("href").contains("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR")) &&(! links.get(i).getAttribute("href").contains("javascript:"))) {
				activelinks.add(links.get(i));*/
		for(int i=0;i<links.size();i++) {
		WebElement element = links.get(i);
		// By using "href" attribute, we could get the url of the requried link
		String url = element.getAttribute("href");
		//System.out.println(links.get(i).getAttribute("href"));
		// calling verifyLink() method here. Passing the parameter as url which we
		// collected in the above link
		// See the detailed functionality of the verifyLink(url) method below
		verifyLink(url);
			
			}
		}
	
	/* get the size of the active links list:
		
		System.out.println("Total Active links and Images are =====> " + links.size());
		
		//check the href URL , with httpconnection api :
		
		//200 --ok
		//404 -- not found
		//500 -- internal error
		//400 -- bad request
		
		for(int j=0;j<activelinks.size();j++) {
			
						HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
			
			connection.connect();
			String response = connection.getResponseMessage();  //ok
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+ "====>"+response);
			
			driver.close(); */
	
	
	// The below function verifyLink(String urlLink) verifies any broken links and
	// return the server status.
	public static void verifyLink(String urlLink) {
		// Sometimes we may face exception "java.net.MalformedURLException". Keep the
		// code in try catch block to continue the broken link analysis
		try {
			// Use URL Class - Create object of the URL Class and pass the urlLink as
			// parameter
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			// Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			// connect using connect method
			httpConn.connect();
			// use getResponseCode() to get the response code.
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
		}
		// getResponseCode method returns = IOException - if an error occurred
		// connecting to the server.
		catch (Exception e) {
			// e.printStackTrace();
		}
	}



	
	}
	
	

