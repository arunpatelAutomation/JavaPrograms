package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To launch softwaretestingmaterial.com
		driver.get("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
		driver.findElement(By.id("ctl00_contentbody_txtEmailAddress")).sendKeys("arunkumar.patel@ee.doe.gov");
		driver.findElement(By.id(
				"ctl00_contentbody_ZMbNOEXnLFIMpoBoGQ1ShzsTJIRKFpxerv2llRbl60uEgvH4PMsjJXQuiLgVMQIhFLDbkx2VRUhlAXK3qDbdhbBWTF5iztPxtvlGQWjN4QpbE0c0w86kFqDZO4T725W"))
				.sendKeys("Actionet9988");
		driver.findElement(By.id("ctl00_contentbody_btnLogin")).click();
		
	/*	driver.findElement(By.linkText("Covered Facilities")).click();
		driver.findElement(By.xpath("//option[contains(text(),'DHS/FLETC - Federal Law Enforcement Training Center')]")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_contentbody_ucSearchControl_btnApply']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'XY')]/following::td[3]")).click(); */
		
		driver.findElement(By.xpath("//a[@id='topNav3']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'DOC')]")).click();
		driver.findElement(By.xpath("//td[contains(text(),'DOC')]/following::td[13]")).click();
		Thread.sleep(5000);
		////td[contains(text(),'Covered Facility (FY 2019)')]/following::table[1]
		driver.findElement(By.xpath("//a[contains(text(),'Go Back')]")).click();
		////td[contains(text(),'Covered Facility Compliance')]/following::table[1]
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[contains(text(),'Covered Facility Compliance')]/following::table[1]")).click();
		
		
	}

}
