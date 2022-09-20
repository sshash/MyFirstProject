package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath="//span[contains(text(),'Order')]")
	WebElement Orderdetails;
	
	@FindBy(xpath="//span[contains(text(),'wishlists')]")
	WebElement wishLists;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validatemyWishlist()
	{
		return this.wishLists.isDisplayed();
	}
	
	public boolean validateorderDetailst()
	{
		return this.Orderdetails.isDisplayed();
	}
	
	public String getCurrURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
