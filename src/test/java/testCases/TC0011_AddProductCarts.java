package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ProductDetailPage;
import pageObject.ProductsPage;

public class TC0011_AddProductCarts extends BaseTest{
	
	@Test(groups="functional")
	
	void CartDetails()
	{  
		try {
		HomePage hp= new HomePage(driver);
		hp.clickProducts();
		logger.info("Home Page started for Product Details Test Script!!");
		
		removeAds(driver);
		
		ProductDetailPage PDP= new ProductDetailPage(driver);
		logger.info("Click on First Product!!");
		PDP.addFirstProductToCart();
		removeAds(driver);
		logger.info("Click on Continue Shopping!!");
		PDP.clickContinueShopping();
		logger.info("Click on Second Product!!!!");
		PDP.addSecondProductToCart();
		removeAds(driver);
		logger.info("Continue Shopping!!");
		PDP.clickContinueShopping();
		
		
		PDP.clickViewCart();
		logger.info("Click on ViewCart!!");
		removeAds(driver);
		CartPage CP =new CartPage(driver);
		logger.info("Products added to cart");
		Assert.assertTrue(CP.areProductsAdded(), "Products not added to cart");

        // Step 10: Verify prices, quantity, and totals
        System.out.println("First Product Price: " + CP.getFirstProductPrice());
        System.out.println("Second Product Price: " + CP.getSecondProductPrice());
        System.out.println("First Product Quantity: " + CP.getFirstProductQuantity());
        System.out.println("Second Product Quantity: " + CP.getSecondProductQuantity());
        System.out.println("First Product Total: " + CP.getFirstProductTotal());
        System.out.println("Second Product Total: " + CP.getSecondProductTotal());

        Assert.assertEquals(CP.getFirstProductQuantity(), "1");
        Assert.assertEquals(CP.getSecondProductQuantity(), "1");
		}
		
		catch(Exception e) {
			e.getMessage();
			
		}
	}
	
	

}
