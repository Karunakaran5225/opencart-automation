package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opencart.actiondriver.Action;

import com.opencart.base.BaseClass;

public class IndexPage extends BaseClass {
	@FindBy(xpath = "//*[@id=\"top\"]/div/div/div[2]/ul/li[2]/div/a/i[2]")
	WebElement accountDropdown;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	@FindBy(xpath = "//img[@alt='Your Store']")
	WebElement opencartLogo;

	@FindBy(xpath = "//input[@name='search']")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogin() throws Throwable {
		Action.click(driver, accountDropdown);
		Action.click(driver, loginLink);
		return new LoginPage();
	}

	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(driver, opencartLogo);
	}

	public String getOpenCartTitle() {
		String opencartTitle = driver.getTitle();
		return opencartTitle;
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();

	}
	
	public RegisterPage clickRegister() throws Throwable {
	    Action.click(driver, accountDropdown);
	    Action.click(driver, registerLink);
	    return new RegisterPage();
	}

	
	

}
