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
		PageFactory.initElements(driver, this);
	}

	public boolean isProductAvailable() {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCart clickOnProduct(){
		Action.click(driver, productResult);
		return new AddToCart();
		
	}

}
