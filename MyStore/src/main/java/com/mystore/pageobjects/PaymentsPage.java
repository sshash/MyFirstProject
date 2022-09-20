package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentsPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement paybyBank;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement paybyCheck;
	
	public PaymentsPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary confirmPaymentMethod()
	{
		Action.click(getDriver(), paybyBank);
		return new OrderSummary();
	}

}
