package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{

	@FindBy(xpath="//input[@name='cgv']")
	WebElement terms;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed')])[2]")
	WebElement proceedtoCheckOut;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void termsisChecked()
	{
		Action.click(getDriver(), terms);
	}
	
	public PaymentsPage proceedCheckout()
	{
		Action.click(getDriver(), proceedtoCheckOut);
		return new PaymentsPage();
	}
}
