package com.FirstProject.testccases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	
	@Test(groups="Smoke",dataProvider="credentials", dataProviderClass=DataProviders.class)
	public void validatewishList(String uname, String psswd)
	{
		indexpage=new IndexPage();
		loginPage=indexpage.clickonSignIn();
		//homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.Login(uname, psswd);
		boolean result=homePage.validatemyWishlist();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke",dataProvider="credentials", dataProviderClass=DataProviders.class)
	public void validateOrderHistoryTest(String uname, String psswd)
	{
		indexpage=new IndexPage();
		loginPage=indexpage.clickonSignIn();
		//homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.Login(uname, psswd);
		boolean result=homePage.validateorderDetailst();
		Assert.assertTrue(result);
	}
}
