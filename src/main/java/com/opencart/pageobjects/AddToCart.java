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
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}

	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);

	}

	public boolean validateAddToCart() {
		Action.fluentWait(driver, addToCartBtn, 10);
		return Action.isDisplayed(driver, addTocartMessage);
	}

	public OrderPage clickCartBtn() {
		Action.fluentWait(driver, cartBtn, 10);
		Action.click(driver, cartBtn);
		return new OrderPage();

	}

	public OrderPage clickOnCheckOut() {
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}

}
