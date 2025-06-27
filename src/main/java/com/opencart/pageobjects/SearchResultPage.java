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
public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//img[@alt='iPhone']")
	WebElement productResult;

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCart clickOnProduct(){
		Action.click(getDriver(), productResult);
		return new AddToCart();
		
	}

}
