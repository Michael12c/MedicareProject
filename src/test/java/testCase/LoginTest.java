package testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;

public class LoginTest extends BasePage {

    @Test(priority = 0)
    public void FailedloginTest() throws IOException {
        // Enter login credentials
    	WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		//LoginBtn = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
		
		WebElement Emailfield = driver.findElement(By.id("username"));
		Emailfield.sendKeys("kn11@gmail.com");
		
		WebElement Passwordfield = driver.findElement(By.id("password"));
		Passwordfield.sendKeys("1234567");
		
		WebElement LoginBtn1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		LoginBtn1.click();
    }
		
    	@Test(priority = 2)
    	public void invalidLogin() throws InterruptedException, IOException {
    		
    		WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
    		//LoginBtn = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
    		LoginBtn.click();
    		
    		WebElement Emailfield = driver.findElement(By.id("username"));
    		Emailfield.sendKeys("kn11@gmail.com");
    		
    		WebElement Passwordfield = driver.findElement(By.id("password"));
    		Passwordfield.sendKeys("wrongpassword");

    		WebElement LoginBtn1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
    		LoginBtn1.click();

    		Thread.sleep(3000);

    		String expectedUrl = "http://localhost:8080/medicare/login";
    		String actualUrl = driver.getCurrentUrl();

    		Assert.assertEquals(actualUrl, expectedUrl);
    		
    		// Take screenshot on failed test case and save it in the Properties folder
    		if(!actualUrl.equals(expectedUrl)) {
    			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    			FileUtils.copyFile(scrFile, new File("Properties/failedTest.png"));
    		}
    	}
    }
