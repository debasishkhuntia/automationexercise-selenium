package pageObject;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends HomePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	//Locators

    @FindBy(xpath = "//h2[@class='title text-center' and text()='All Products']")
    private WebElement allProductsHeader;

    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement productsList;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstProductViewButton;
    
    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchButton;
    
    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsHeading;
    
    @FindBy(xpath = "//div[@class='productinfo text-center']")
    List<WebElement> searchedProductsList;

    //Actions
  

    public boolean isProductsListVisible() {
        return productsList.isDisplayed();
    }
    
    public void clickViewProductOfFirstProduct() {
    	
    	firstProductViewButton.click();;
    }
  
    
    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
    public boolean isSearchProductsPageVisible() {
        return searchedProductsHeading.isDisplayed();
    }
    
    
    public boolean isAllProductsPageVisible() {
        return allProductsHeader.isDisplayed();
    }
    
    
    public boolean areSearchResultsDisplayed() {
        return searchedProductsList.size() > 0;
    }

    /*public void clickViewProductOfFirstProduct() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", firstProductViewButton);
    }*/
    

}
