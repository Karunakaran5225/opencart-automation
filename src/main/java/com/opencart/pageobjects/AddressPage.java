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
public class AddressPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"shipping-addresses\"]/div[1]/label")
	WebElement selectAddressOtn;
	
	@FindBy(xpath ="//*[@id=\"input-shipping-address\"]")
	WebElement dropDown;

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnAddress() {
		Action.fluentWait(getDriver(), dropDown, 10);
		Action.click(getDriver(), selectAddressOtn);
		Action.click(getDriver(), dropDown);
		Action.selectByVisibleText("Karunakaran Vijayakumar, Chennai, Chennai, Tamil Nadu, India", dropDown);
		return new ShippingPage();
	}

}
