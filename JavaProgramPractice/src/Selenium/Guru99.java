package Selenium;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 // Launch the application
		
		WebElement w;
    	 driver.get("https://www.guru99.com/");
    	 
    	 //Search the element by using descendant method
    	 w=driver.findElement(By.xpath("//*[@id='rt-feature']//descendant::a"));
     	
		//Print the searched element
    	 System.out.println(w.getText());
	 
	//Close the browser
    driver.quit();
    }
}