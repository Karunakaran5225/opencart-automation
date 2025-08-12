/**
 * 
 */
package com.opencart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Sanity")
	public void verifyAccountRegisterPageTest() throws Throwable {
		indexPage = new IndexPage();
		registerPage = indexPage.clickRegister();
		homePage = registerPage.createAccount("Jane", "Smith", "jane.smith@example.com", "Test@1234");

	}
}
