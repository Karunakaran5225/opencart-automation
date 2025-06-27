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
import com.opencart.pageobjects.SearchResultPage;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void productAvailabiltyTest() throws Throwable {
	indexPage=new IndexPage();
	searchResultPage=indexPage.searchProduct("iphone");
	boolean result=searchResultPage.isProductAvailable();
	Assert.assertTrue(result);
		
		
	}

}
