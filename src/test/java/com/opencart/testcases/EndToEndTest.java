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
import com.opencart.pageobjects.AddressPage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.OrderConfirmationPage;
import com.opencart.pageobjects.OrderPage;
import com.opencart.pageobjects.OrderSummaryPage;
import com.opencart.pageobjects.PaymentPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShippingPage;

/**
 * 
 */
public class EndToEndTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCart addToCart;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	

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
	public void endToEndTest() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("iphone");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.clickOnAddToCart();
		orderPage=addToCart.clickCartBtn();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnAddress();
		paymentPage=shippingPage.chooseShippingMethod();
		orderSummaryPage=paymentPage.choosePaymentMethod();
		orderConfirmationPage=orderSummaryPage.clickonConfirmOrder();
		String confirmMsg=orderConfirmationPage.validateConfirmMsg();
		String expectedMsg="Your order has been placed!";
		Assert.assertEquals(confirmMsg, expectedMsg);
	}

}
