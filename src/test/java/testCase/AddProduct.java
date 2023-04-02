package testCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;


public class AddProduct extends BasePage {



	@Test
	public void AdminLogin  () throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions builder = new Actions(this.driver);

		WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();

		WebElement Emailfield = driver.findElement(By.id("username"));
		Emailfield.sendKeys("vk@gmail.com");

		WebElement Passwordfield = driver.findElement(By.id("password"));
		Passwordfield.sendKeys("admin");

		WebElement LoginBtn1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		LoginBtn1.click();

		WebElement UserName = driver.findElement(By.linkText("Vikas Kashyap"));
		Assert.assertEquals(true, UserName.isDisplayed());
		System.out.println("User has logged in succesfully");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Medicare - Home";

		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");

		/*
		//Update Quantity to existing Product
		WebElement ViewProducts = driver.findElement(By.linkText("View Products"));
		wait.until(ExpectedConditions.visibilityOf(ViewProducts));
		builder.moveToElement(ViewProducts);
		builder.build().perform();
		ViewProducts.click();

		WebElement EditProducts = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]"));
		wait.until(ExpectedConditions.visibilityOf(EditProducts));
		builder.build().perform();
		EditProducts.click();

		WebElement Quantity = driver.findElement(By.name("quantity"));
		Quantity.clear();
		Quantity.sendKeys("100");

		WebElement Save = driver.findElement(By.name("submit"));
		Save.click();

		WebElement ProdQty = driver.findElement(By.xpath("//*[@id=\"productsTable\"]/tbody/tr[1]/td[5]"));
		Assert.assertEquals(true, ProdQty.isDisplayed());
		System.out.println("Product Qty Updated");
		 */

		//Add New Product
		WebElement ManageProduct = driver.findElement(By.linkText("Manage Product"));
		wait.until(ExpectedConditions.visibilityOf(ManageProduct));
		builder.moveToElement(ManageProduct);
		builder.build().perform();
		ManageProduct.click();

		WebElement ProdName = driver.findElement(By.id("name"));
		ProdName.sendKeys("Test Asprin");
		WebElement BrandName = driver.findElement(By.id("brand"));
		BrandName.sendKeys("Test Brand");
		WebElement Descript = driver.findElement(By.id("description"));
		Descript.sendKeys("This is a random description for a Test Asprin");
		WebElement Price = driver.findElement(By.id("unitPrice"));
		Price.clear();
		Price.sendKeys("10");
		WebElement Quantity1 = driver.findElement(By.name("quantity"));
		Quantity1.clear();
		Quantity1.sendKeys("20");
		WebElement browse = driver.findElement(By.xpath("//*[@id=\"file\"]"));
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\Users\\Administrator\\eclipse-workspace\\medicareTest\\Asprin.jpeg"); //Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		WebElement Submit = driver.findElement(By.name("submit"));
		wait.until(ExpectedConditions.visibilityOf(Submit));
		builder.build().perform();
		Submit.click();


		//Check New Product Added
		WebElement ViewProducts = driver.findElement(By.linkText("View Products"));
		wait.until(ExpectedConditions.visibilityOf(ViewProducts));
		builder.moveToElement(ViewProducts);
		builder.build().perform();
		ViewProducts.click();

		WebElement NxtPage = driver.findElement(By.xpath("//*[@id=\"productListTable_next\"]/a"));
		wait.until(ExpectedConditions.visibilityOf(NxtPage));
		builder.moveToElement(NxtPage);
		builder.build().perform();
		NxtPage.click();


		WebElement table = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[2]/td[2]"));
		Assert.assertTrue(isTableContainsText(table, "Test Asprin"));
		//Assert.assertFalse(isTableContainsText(table, " "));

	}

		public boolean isTableContainsText(WebElement table, String text){
			if (table.getText().contains(text)){
			System.out.println("New Product Added: " + text);
			return true;
			}

			return false;
		}


}



