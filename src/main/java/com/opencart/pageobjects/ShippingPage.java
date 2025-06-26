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
public class ShippingPage extends BaseClass {

	@FindBy(id = "button-shipping-methods")
	WebElement shippingMethod;

	@FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
	WebElement continueBtn;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public PaymentPage chooseShippingMethod() {
		Action.fluentWait(driver, continueBtn, 10);
		Action.click(driver, shippingMethod);
		Action.click(driver, continueBtn);
		return new PaymentPage();
	}

}
