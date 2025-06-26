/**
 * 
 */
package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.actiondriver.Action;
import com.opencart.base.BaseClass;

/**
 * 
 */
public class RegisterPage extends BaseClass {
	@FindBy(xpath = "//h1[text()='Register Account']")
	WebElement formTitle;

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement emailId;

	@FindBy(id = "input-password")
	WebElement passWord;

	@FindBy(xpath = "//*[@id=\"form-register\"]/div/div/input")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueBtn;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage createAccount(String fName, String lName, String email, String pswd) {
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(emailId, email);
		Action.type(passWord, pswd);
		Action.click(driver, checkbox);
		Action.click(driver, continueBtn);
		return new HomePage();

	}

	public boolean validateRegisterPage() {
		return Action.isDisplayed(driver, formTitle);
	}

}
