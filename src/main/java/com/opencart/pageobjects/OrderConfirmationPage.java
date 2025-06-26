/**
 * 
 */
package com.opencart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opencart.base.BaseClass;

/**
 * 
 */
public class OrderConfirmationPage extends BaseClass {
	@FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
	WebElement confirmMsg;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmMsg() {
		String confirmMessage=confirmMsg.getText();
		return confirmMessage;
	}
}
