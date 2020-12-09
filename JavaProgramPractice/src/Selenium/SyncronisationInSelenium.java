package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncronisationInSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//implicitly wait -- is always applied globally---is available for all the webelements 
		//we can over write Implicit wait
		//Dynamic waits
		//Implicitly wait applies first then Explicitly wait
		//Thread.sleep is - Static wait
		//Explicit wait
		//1. Nio explicit kleyword or method
		//2. available with WebDriverWait with some expectedconditions
		//3.Specific to element
		//4. Dynamic in nature - if element found in 5 seconds rest of wait ignored
		//5. we should never use Implicit and explict wait togenter
		// selenium WD will wait for the element first because of implicit wait and then explicit wait will be applied
		//hence, total Sync wait will be increased for each  element
		
		
		driver.get("https://www.eisa-432-cts.eere.energy.gov/EISACTS_MIR/Login.aspx");
		
		WebElement uName = driver.findElement(By.xpath("//input[@id='ctl00_contentbody_txtEmailAddress']"));
		WebElement pword = driver.findElement(By.id(
				"ctl00_contentbody_ZMbNOEXnLFIMpoBoGQ1ShzsTJIRKFpxerv2llRbl60uEgvH4PMsjJXQuiLgVMQIhFLDbkx2VRUhlAXK3qDbdhbBWTF5iztPxtvlGQWjN4QpbE0c0w86kFqDZO4T725W"));
		WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_contentbody_btnLogin']"));
		
		sendkeys(driver, uName, 10, "arunkumar.patel@ee.doe.gov");
		sendkeys(driver, pword, 5, "Actionet9988");
		clickOn(driver, login, 5);

	}

		public static void sendkeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
		public static void clickOn(WebDriver driver, WebElement element, int timeout) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
	}
	
	
	
}
