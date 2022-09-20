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
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
	
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
	
	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class ,groups= {"Smoke","Sanity"})
	public void loginTest(String uname, String psswd) throws InterruptedException
	{
		Log.startTestCase("Login Test");
		indexpage=new IndexPage();
		Log.info("User is going to click on SignIn");
		Thread.sleep(2000);
		loginPage=indexpage.clickonSignIn();
		Thread.sleep(10000);
		Log.info("Enter UserName and Password");
		//homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.Login(uname,psswd);
		String actualURL=homePage.getCurrURL();
		String expURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifing if user is able to login");
		Assert.assertEquals(actualURL, expURL);
		Log.info("User Succesfully Loginned");
		Log.endTestCase("Login Test");
	}

}
