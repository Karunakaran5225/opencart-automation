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
import com.opencart.pageobjects.AddToCart;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.OrderPage;
import com.opencart.pageobjects.SearchResultPage;

/**
 * 
 */
public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCart addToCart;
	OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Regression")
	public void verifyTotalPrice() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("iphone");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.clickOnAddToCart();
		orderPage=addToCart.clickCartBtn();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice=orderPage.getTotalPrice();
		double totalExpectedPrice=(unitPrice*2);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
	}

}
