package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.ProductsPage;

public class TC009_SearchProduct extends BaseTest{
	@Test(groups="regression")
	 public void verifyProductSearch()
	 {
		 System.out.println("Test Case execution Started");
		 HomePage HP=new HomePage(driver);


		 HP.clickProducts();
		 ProductsPage PP= new ProductsPage(driver);
		 
		 Assert.assertTrue(PP.isAllProductsPageVisible(), "All Products page not visible");
		 
		 PP.searchProduct("Dress");
		 
		  Assert.assertTrue(PP.isSearchProductsPageVisible(),
	                "Searched Products heading not visible");

	        Assert.assertTrue(PP.areSearchResultsDisplayed(),
	                "Search results are not displayed");
		 
	 }

}
