/**
 * 
 */
package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() {
		String acttitle=indexPage.getOpenCartTitle();
		String expected="Your Store";
		Assert.assertEquals(acttitle, expected);
		
	}

}
