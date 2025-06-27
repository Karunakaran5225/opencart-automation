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
public class AddToCart extends BaseClass {

	@FindBy(id = "input-quantity")
	WebElement quantity;

	@FindBy(xpath = "//button[text()='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(id = "alert")
	WebElement addTocartMessage;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div/div[2]/ul/li[4]/a")
	WebElement cartBtn;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement proceedToCheckOutBtn;

	public AddToCart() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}

	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);

	}

	public boolean validateAddToCart() {
		Action.fluentWait(getDriver(), addToCartBtn, 10);
		return Action.isDisplayed(getDriver(), addTocartMessage);
	}

	public OrderPage clickCartBtn() {
		Action.fluentWait(getDriver(), cartBtn, 10);
		Action.click(getDriver(), cartBtn);
		return new OrderPage();

	}

	public OrderPage clickOnCheckOut() {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}

}
