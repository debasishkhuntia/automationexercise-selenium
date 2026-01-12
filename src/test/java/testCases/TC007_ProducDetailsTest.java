package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.ProductDetailPage;
import pageObject.ProductsPage;

public class TC007_ProducDetailsTest extends BaseTest{
	@Test(groups="regression")
	void Products()
	{
		System.out.println("Test Case execution Started");
		HomePage HP= new HomePage(driver);
		HP.clickProducts();
		
		ProductsPage PP=new ProductsPage(driver);
		
		Assert.assertTrue(PP.isAllProductsPageVisible(), "Not Found");
		
		Assert.assertTrue(PP.isProductsListVisible(), "Product Details Not Found");
		
		
		try {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    // Specifically target the iframe ID from your error log
		    js.executeScript("var element = document.getElementById('aswift_3'); if(element) { element.remove(); }");
		} catch (Exception e) {
		    System.out.println("Ad iframe not found or already removed.");
		}
		// Now perform the standard click
		PP.clickViewProductOfFirstProduct();

		//PP.clickViewProductOfFirstProduct();
		
		ProductDetailPage PD= new ProductDetailPage(driver);
		
		

		
		System.out.println(PD.areProductDetailsVisible());
		
		System.out.println("Test Case execution Ended");
	}

}
