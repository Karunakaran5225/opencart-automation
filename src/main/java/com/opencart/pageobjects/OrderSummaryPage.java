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
public class OrderSummaryPage extends BaseClass {
	@FindBy(xpath = "//*[@id=\"button-confirm\"]")
	WebElement confirmOrderBtn;

	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage clickonConfirmOrder() {
//		Action.fluentWait(driver, confirmOrderBtn, 10);
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
