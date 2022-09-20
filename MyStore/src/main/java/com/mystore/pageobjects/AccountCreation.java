package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreation extends BaseClass {
	
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement AccountCreationHeading;
	
	@FindBy(xpath="//h3[text()='Your personal information']")
	WebElement AccountCreationSubHeading;
	
	public AccountCreation()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateHeading()
	{
		return this.AccountCreationHeading.isDisplayed();
	}
	
	public boolean validateSubHeading()
	{
		return this.AccountCreationSubHeading.isDisplayed();
	}
}
