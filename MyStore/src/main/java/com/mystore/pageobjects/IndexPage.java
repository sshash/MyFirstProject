package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//a[@title='My Store']/child::img")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@name='search_query']")
	WebElement searchProd;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchBtn;
	
	
	public IndexPage()
	{
		PageFactory.initElements( getDriver(), this);
	}
	
	public LoginPage clickonSignIn()
	{
		this.signInBtn.click();
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return this.myStoreLogo.isDisplayed();
	}
	
	public String getTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResult searchProduct(String productName)
	{
		this.searchProd.sendKeys(productName);
		this.searchBtn.click();
		return new SearchResult();
	}

}
