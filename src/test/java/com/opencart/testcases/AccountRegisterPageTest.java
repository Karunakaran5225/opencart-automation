/**
 * 
 */
package com.opencart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.RegisterPage;

/**
 * 
 */
public class AccountRegisterPageTest extends BaseClass {
	IndexPage indexPage;
	RegisterPage registerPage;
	HomePage homePage;
	RegisterPage accountRegisterPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyAccountRegisterPageTest() throws Throwable {
		indexPage = new IndexPage();
		registerPage = indexPage.clickRegister();
		homePage = registerPage.createAccount("Jane", "Smith", "jane.smith@example.com", "Test@1234");

	}
}
