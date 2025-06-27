/**
 * 
 */
package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;

/**
 * 
 */
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage=indexPage.clickLogin();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void orderHistoryandDetailsTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage=indexPage.clickLogin();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result1=homePage.ValidateOrderHistory();
		Assert.assertTrue(result1);}

}
