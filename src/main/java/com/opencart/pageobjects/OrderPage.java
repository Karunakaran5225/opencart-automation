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
public class OrderPage extends BaseClass {
	@FindBy(xpath = "//div[@id='shopping-cart']//tbody/tr/td[4]")
	WebElement unitPrice;

	@FindBy(xpath = "//*[@id=\"checkout-total\"]/tr[4]/td[2]")
	WebElement totalPrice;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement proceedToCheckOut;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	public double getUnitPrice() throws InterruptedException {
		String unitPrice1 = unitPrice.getText();
		Thread.sleep(3000);
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	public double getTotalPrice() throws InterruptedException {
		String totalPrice1 = totalPrice.getText();
		Thread.sleep(3000);
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice / 100;
	}

	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
	}

}
