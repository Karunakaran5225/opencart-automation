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
import com.opencart.pageobjects.SearchResultPage;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
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
	public void productAvailabiltyTest() throws Throwable {
	indexPage=new IndexPage();
	searchResultPage=indexPage.searchProduct("iphone");
	boolean result=searchResultPage.isProductAvailable();
	Assert.assertTrue(result);
		
		
	}

}
