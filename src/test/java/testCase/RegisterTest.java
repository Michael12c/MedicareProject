package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;

public class RegisterTest extends BasePage{


	@Test
	public void Login() throws InterruptedException{

		WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		LoginBtn.click();

		WebElement Emailfield = driver.findElement(By.id("username"));
		Emailfield.sendKeys("kn@gmail.com");

		WebElement Passwordfield = driver.findElement(By.id("password"));
		Passwordfield.sendKeys("12345");

		WebElement LoginBtn1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		LoginBtn1.click();

		WebElement UserName = driver.findElement(By.id("userModel"));
		Assert.assertEquals(true, UserName.isDisplayed());
		System.out.println("UserName is displayed – Assert passed");

		String actualTitle = driver.getTitle();

		String expectedTitle = "Medicare - Home";

		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");

	}
}
