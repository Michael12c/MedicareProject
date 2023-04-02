package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


public class BasePage {
	
public WebDriver driver;
	
		
	@BeforeClass
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
	    
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/medicare/home");
		driver.manage().window().maximize();

	}
	
	@AfterClass (alwaysRun = true)
	public void closeBrowser() {
		
		driver.close();
		
	}
	

}
