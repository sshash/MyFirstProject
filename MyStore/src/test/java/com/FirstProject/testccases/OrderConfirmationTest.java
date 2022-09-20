package com.FirstProject.testccases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.Address;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.Order;
import com.mystore.pageobjects.OrderConfirmation;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentsPage;
import com.mystore.pageobjects.SearchResult;
import com.mystore.pageobjects.ShippingPage;

public class OrderConfirmationTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResult Searchresult;
	AddToCart Addtocart;
	Order orderpage;
	Address address;
	ShippingPage shippingpage;
	PaymentsPage Paymentspage;
	OrderSummary ordersummary;
	OrderConfirmation orderConfirmation;
	
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
	public void validateOrderConfirmTest(String prod,String quant,String size) throws InterruptedException
	{
		indexpage=new IndexPage();
		Searchresult=indexpage.searchProduct(prod);
		Addtocart=Searchresult.addItemsToCart();
		Addtocart.enterQuantity(quant);
		Addtocart.enterSize(size);
		Addtocart.clicktoCart();
		Thread.sleep(3000);
		orderpage=Addtocart.proceedToCheckout();
		loginPage=orderpage.checkout();
		address=loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage=address.checkout();
		shippingpage.termsisChecked();
		Paymentspage=shippingpage.proceedCheckout();
		ordersummary=Paymentspage.confirmPaymentMethod();
		orderConfirmation=ordersummary.confirmOrder();
		Thread.sleep(3000);
		String actres=orderConfirmation.validateconfirmMessage();
		String expres="Your order on My Store is complete.";
		Assert.assertEquals(actres, expres);
	}
}
