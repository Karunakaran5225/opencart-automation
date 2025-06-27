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
		PageFactory.initElements(getDriver(), this);
	}

	public PaymentPage chooseShippingMethod() {
		Action.fluentWait(getDriver(), continueBtn, 10);
		Action.click(getDriver(), shippingMethod);
		Action.click(getDriver(), continueBtn);
		return new PaymentPage();
	}

}
