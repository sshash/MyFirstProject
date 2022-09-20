package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResult extends BaseClass{
	
	@FindBy(xpath="//img[@alt='Faded Short Sleeve T-shirts']")
	WebElement prodImage;
	
	public SearchResult()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateSearchResult()
	{
		return this.prodImage.isDisplayed();
	}
	
	public AddToCart addItemsToCart()
	{
		this.prodImage.click();
		return new AddToCart();
	}
	}
