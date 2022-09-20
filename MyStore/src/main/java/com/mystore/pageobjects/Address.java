package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class Address extends BaseClass {
	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement checkOutBtn;
	
	
	public Address()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage checkout()
	{
		Action.click(getDriver(), checkOutBtn);
		return new ShippingPage();
	}
	

}
