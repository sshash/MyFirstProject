package com.FirstProject.testccases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreation;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginPage;
	AccountCreation Accountcreation;
	
	@Parameters("browser")
	@BeforeMethod(groups={"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod(groups={"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="Sanity",dataProvider="email",dataProviderClass=DataProviders.class)
	public void validateAccountCreated(String email)
	{
		indexpage=new IndexPage();
		loginPage=indexpage.clickonSignIn();
		Accountcreation=loginPage.createnewAccount(email);
		boolean hding=Accountcreation.validateHeading();
		boolean subhding=Accountcreation.validateSubHeading();
		Assert.assertTrue(hding);
		Assert.assertTrue(subhding);
	}

}
