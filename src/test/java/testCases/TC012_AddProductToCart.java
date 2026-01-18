package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ProductDetailPage;
import pageObject.ProductsPage;

public class TC012_AddProductToCart extends BaseTest{
	@Test(groups="functional")
	void verifyProductQuantityInCart()
	{  
		try {
		
		removeAds(driver);
		HomePage hp= new HomePage(driver);
		logger.info("Click on Hpme Page");
		System.out.println("Click on Hpme Page");
		hp.clickProducts();
		System.out.println("Find the First Product!!");
		
		ProductsPage PrdPage= new ProductsPage(driver);
		 logger.info("Find the First Product!!");
		 removeAds(driver);
		
		
		PrdPage.clickViewProductOfFirstProduct();
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		driver.getPageSource().contains("quantity");
		System.out.println("Click on Set Quantity!!");
		ProductDetailPage PDP= new ProductDetailPage(driver);
		PDP.setQuantity("4");
		PDP.addToCart();
		 logger.info("Click on Add Product");
		System.out.println("Click on Add Product");
		PDP.clickView();
		CartPage CP= new CartPage(driver);
		System.out.println(CP.getProductQuantity());
		/*
		
		System.out.println("Add Product to Cart Start");
		//PDP.addFirstProductToCart();
		PDP.openFirstProductDetails();
		System.out.println("Click on View Details!!");
		PDP.clickViewCart();
		System.out.println("Click on View!!");
		PDP.clickView();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		driver.getPageSource().contains("quantity");
		System.out.println("Click on Set Quantity!!");
		PDP.setQuantity("4");
		PDP.addToCart();
		System.out.println("Click on Add Product");
		
		CartPage CP =new CartPage(driver);
		
		System.out.println(CP.getProductQuantity());
		*/
		}catch(Exception e)
		{
			e.getMessage();
		}
	}
}
