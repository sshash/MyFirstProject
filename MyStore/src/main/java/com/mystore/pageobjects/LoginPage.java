package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@name='email_create']")
	WebElement createEmail;
	
	@FindBy(xpath="//button[@name='SubmitCreate']")
	WebElement submitCreate;
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	WebElement signIn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage Login(String uname, String pswd)
	{
		this.userName.sendKeys(uname);
		this.passWord.sendKeys(pswd);
		this.signIn.click();
		return new HomePage();
	}
	
	public Address Login1(String uname, String pswd)
	{
		this.userName.sendKeys(uname);
		this.passWord.sendKeys(pswd);
		this.signIn.click();
		return new Address();
	}
	
	public AccountCreation createnewAccount(String email)
	{
		this.createEmail.sendKeys(email);
		this.submitCreate.click();
		return new AccountCreation();
	}

}
