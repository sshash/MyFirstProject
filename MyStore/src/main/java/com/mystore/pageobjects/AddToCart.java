package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCart extends BaseClass {
	
	@FindBy(xpath="//input[@name='qty']")
	WebElement quant;
	
	@FindBy(xpath="//select[@name='group_1']")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement assToCartBtn;
	
	@FindBy(xpath="//div[@id='layer_cart']//h2//i")
	WebElement validatecart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceed;
	
	Action ac=new Action();
	
	public AddToCart()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity)
	{
		this.quant.sendKeys(Keys.BACK_SPACE);
		this.quant.sendKeys(quantity);
	}
	
	public void enterSize(String size1)
	{
		Action.selectByVisibleText(size1,size);
	}
	
	public void clicktoCart()
	{
		this.assToCartBtn.click();
	}
	
	public boolean validateAddToCart()
	{
		return this.validatecart.isDisplayed();
	}
	
	public Order proceedToCheckout()
	{
		this.proceed.click();
		return new Order();
	}

}
