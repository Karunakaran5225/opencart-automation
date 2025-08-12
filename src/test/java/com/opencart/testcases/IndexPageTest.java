/**
 * 
 */
package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Smoke")
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		String acttitle=indexPage.getOpenCartTitle();
		String expected="Your Store";
		Assert.assertEquals(acttitle, expected);
		
	}

}
