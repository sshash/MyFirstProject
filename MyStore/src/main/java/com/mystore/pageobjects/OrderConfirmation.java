package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmation extends BaseClass {
	
	@FindBy(xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement confirmedOrder;
	
	public OrderConfirmation()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateconfirmMessage()
	{
		String confrmmesg=confirmedOrder.getText();
		return confrmmesg;
		
	}

}
