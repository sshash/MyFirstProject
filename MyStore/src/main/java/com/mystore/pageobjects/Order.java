package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class Order extends BaseClass {
	
	@FindBy(xpath="//td[@data-title='Unit price']//span//span")
	WebElement unitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed')])[2]")
	WebElement proceedtoCheckOut;
	
	public Order()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		String unitprice1=unitPrice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finalunitPrice=Double.parseDouble(unit);
		return finalunitPrice/100;
	}

	public double gettotalPrice()
	{
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finaltotalPrice=Double.parseDouble(total);
		return finaltotalPrice/100;
	}
	
	public LoginPage checkout()
	{
		Action.click(getDriver(), proceedtoCheckOut);
		return new LoginPage();
	}

}
