package com.FirstProject.testccases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResult;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResult Searchresult;
	
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
	
	@Test(groups="Smoke")
	public void validatesearchResultTest()
	{
		indexpage=new IndexPage();
		Searchresult=indexpage.searchProduct("t-shirts");
		boolean result=Searchresult.validateSearchResult();
		Assert.assertTrue(result);
	}
	
	

}
