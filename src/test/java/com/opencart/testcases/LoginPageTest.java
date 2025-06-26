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
import org.testng.Reporter;

/**
 * 
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage=indexPage.clickLogin();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homePage.getCurrURL();
		String expectedURL="http://localhost:8080/opencart/upload/index.php?route=account/account&language=en-gb&customer_token=2424eeb7a49091d23c714dc0a3";
		Assert.assertTrue(actualURL.contains("route=account/account"), "URL mismatch!");
		Reporter.log("Actual URL: " + actualURL, true);
		Reporter.log("Expected URL: " + expectedURL, true);
	}

}
