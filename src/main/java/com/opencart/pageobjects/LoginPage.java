/**
 * 
 */
package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Action;
import com.opencart.base.BaseClass;

/** Since OpenCart Does not have the email address field for new account creation
Will skip the methods for create new account
 * 
 * 
 */
public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/a/i[2]")
	WebElement dropdown;

	@FindBy(id = "input-email")
	WebElement username;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement signInBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement createNewAccountBtn;
	
	@FindBy(xpath="//*[@id=\"form-register\"]/p/a/strong")
	WebElement logIn;
	

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(String uname, String pswd) throws Throwable {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pswd) throws Throwable {
		Action.click(getDriver(), logIn);
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	
	
	
	

	
	

}
