package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;


public class BasePage {

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/medicare/home");
		driver.manage().window().maximize();

	}

	@AfterTest (alwaysRun = true)
	public void closeBrowser() {

		driver.close();

	}

	public void takeScreenshot(String methodName) {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir") + "/test-output/Properties/" + methodName + "_" + timeStamp + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
