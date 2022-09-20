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
import com.mystore.pageobjects.Order;
import com.mystore.pageobjects.SearchResult;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResult Searchresult;
	AddToCart Addtocart;
	Order orderpage;
	
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
	
	@Test(groups="Regression",dataProvider= "getProduct", dataProviderClass=DataProviders.class)
	public void validateOrderTest(String prod,String quant,String size) throws InterruptedException
	{
		indexpage=new IndexPage();
		Searchresult=indexpage.searchProduct(prod);
		Addtocart=Searchresult.addItemsToCart();
		Addtocart.enterQuantity(quant);
		Addtocart.enterSize(size);
		Addtocart.clicktoCart();
		Thread.sleep(3000);
		orderpage=Addtocart.proceedToCheckout(); 
		Double unit=orderpage.getUnitPrice();
		Double tot=orderpage.gettotalPrice();
		Double expprice=(unit*Double.parseDouble(quant))+2;
		Assert.assertEquals(tot, expprice);
	} 

}
