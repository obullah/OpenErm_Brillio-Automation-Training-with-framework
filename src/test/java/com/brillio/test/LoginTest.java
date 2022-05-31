package com.brillio.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends WebDriverWrapper{
	
	@Test
	public void validCredentialTest()
	{
		System.out.println("Valid");
		//System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest()
	{
		System.out.println("Valid");
		//System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.id("clearPass")).sendKeys("1234");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError = driver.findElement(By.xpath("//div[contains(text(),'Invalid']")).getText();
		Assert.assertEquals(actualError, "Invalid username or password");
	}

}
