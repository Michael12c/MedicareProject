package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BasePage;

public class CheckoutTest extends BasePage{
	
	@Test
	public void Checkout () {
		
		WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		//LoginBtn = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
		
		WebElement Emailfield = driver.findElement(By.id("username"));
		Emailfield.sendKeys("kn@gmail.com");
		
		WebElement Passwordfield = driver.findElement(By.id("password"));
		Passwordfield.sendKeys("12345");
		
		WebElement LoginBtn1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		LoginBtn1.click();
		
		
		WebElement View = driver.findElement(By.linkText("View"));
		Actions builder = new Actions(this.driver);

		builder.moveToElement(View);
		builder.click();
		builder.build().perform();
		View.click();
		
		WebElement AddToCart = driver.findElement(By.linkText("Add to Cart"));

		builder.moveToElement(AddToCart);
		builder.click();
		builder.build().perform();
		
		AddToCart.click();
		
		WebElement Checkout = driver.findElement(By.linkText("Checkout"));
		builder.moveToElement(Checkout);
		builder.click();
		builder.build().perform();
		Checkout.click();
		
		WebElement AddressSelect = driver.findElement(By.linkText("Select"));
		builder.moveToElement(AddressSelect);
		builder.click();
		builder.build().perform();
		AddressSelect.click();
		
		WebElement Pay = driver.findElement(By.linkText("Pay"));
		builder.moveToElement(Pay);
		builder.click();
		builder.build().perform();
		Pay.click();
		
		/*
		WebElement ContinueShop = driver.findElement(By.linkText("Continue Shopping"));
		builder.moveToElement(ContinueShop);
		builder.click();
		builder.build().perform();
		ContinueShop.click();
		*/
	}

}

