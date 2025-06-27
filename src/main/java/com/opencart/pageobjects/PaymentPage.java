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
public class PaymentPage extends BaseClass{
	@FindBy(xpath="//*[@id=\"button-payment-methods\"]")
	WebElement paymentMethod;
	
	@FindBy(xpath="//*[@id=\"button-payment-method\"]")
	WebElement continueBtn;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage choosePaymentMethod() {
		Action.click(getDriver(), paymentMethod);
		Action.fluentWait(getDriver(), paymentMethod, 10);
		Action.click(getDriver(), continueBtn);
		return new OrderSummaryPage();
	}

}
