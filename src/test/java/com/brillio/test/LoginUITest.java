package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;

public class LoginUITest extends WebDriverWrapper{
	@Test
	public void validateTitleTest()
	{
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
	}

}
