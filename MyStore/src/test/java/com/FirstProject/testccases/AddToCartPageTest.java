package com.FirstProject.testccases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResult;

public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResult Searchresult;
	AddToCart Addtocart;
	
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
	
	@Test(groups= {"Regression","Sanity"},dataProvider="getProduct", dataProviderClass=DataProviders.class)
	public void validateProductAddedToCartTest(String prod,String quant,String size) throws InterruptedException
	{
		indexpage=new IndexPage();
		Searchresult=indexpage.searchProduct(prod);
		Addtocart=Searchresult.addItemsToCart();
		Addtocart.enterQuantity(quant);
		Addtocart.enterSize(size);
		Addtocart.clicktoCart();
		Thread.sleep(3000);
		boolean result=Addtocart.validateAddToCart();
		Assert.assertTrue(result);		
	}
	

}
