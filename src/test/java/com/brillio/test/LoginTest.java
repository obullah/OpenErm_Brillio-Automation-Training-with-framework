package com.brillio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;
import com.brillio.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {
		
	@Test(dataProviderClass = DataUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedTitle) {
		
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.id("clearPass")).sendKeys(password);
		
		Select selectLan=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(language);
		
		driver.findElement(By.cssSelector("#login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.id("clearPass")).sendKeys("john123");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText().strip();
		Assert.assertEquals(actualError, "Invalid username or password");
	}
	
	
}