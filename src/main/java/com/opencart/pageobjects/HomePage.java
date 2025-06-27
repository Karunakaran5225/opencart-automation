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
public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[text()='Modify your wish list']")
	WebElement myWishList;

	@FindBy(xpath = "//a[text()='View your order history']")
	WebElement OrderHistory;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMyWishList() {
		return Action.isDisplayed(getDriver(), myWishList);

	}

	public boolean ValidateOrderHistory() {
		return Action.isDisplayed(getDriver(), OrderHistory);
	}

	public String getCurrURL() {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}

}
