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
import com.opencart.dataprovider.DataProviders;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.IndexPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.utility.Log;

import org.testng.Reporter;

/**
 * 
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "credentials", dataProviderClass= DataProviders.class, groups={"Smoke","Sanity"})
	public void loginTest(String uname,String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to login");
		loginPage=indexPage.clickLogin();
		Log.info("User is going to enter username and password");
//		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd);
		String actualURL=homePage.getCurrURL();
		String expectedURL="http://localhost:8080/opencart/upload/index.php?route=account/account&language=en-gb&customer_token=2424eeb7a49091d23c714dc0a3";
//		Assert.assertTrue(actualURL.contains("route=account/account"), "URL mismatch!");
		Log.info("Verifying if user is able to login");
		Reporter.log("Actual URL: " + actualURL, true);
		Reporter.log("Expected URL: " + expectedURL, true);
		Log.endTestCase("loginTest ended");
	}

}
