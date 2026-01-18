package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;



public class ProductDetailPage extends HomePage{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	//Locators
	 @FindBy(xpath = "//div[@class='product-details']//h2")
	    private WebElement productName;

	    @FindBy(xpath = "//div[@class='product-details']//p[contains(text(), 'Category')]")
	    private WebElement productCategory;

	    @FindBy(xpath = "//div[@class='product-details']//span/span")
	    private WebElement productPrice;

	    @FindBy(xpath = "//b[text()='Availability:']/parent::p")
	    private WebElement productAvailability;
	    
	    @FindBy(xpath = "//b[text()='Condition:']/parent::p")
	    private WebElement productCondition;

	    @FindBy(xpath = "//b[text()='Brand:']/parent::p")
	    private WebElement productBrand;
	    
	             ///PRODUCT VIEW CART
	    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]/a")
	    WebElement firstProductAddToCart;

	    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]/a")
	    WebElement secondProductAddToCart;

	    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
	    WebElement continueShoppingButton;

	    @FindBy(xpath="//a[normalize-space()='Cart']")
	    WebElement viewCartButton;
	    
	     @FindBy(xpath="//input[@name='quantity']")
	    private WebElement quantityInput;

	     @FindBy(xpath="//button[normalize-space()='Add to cart']")
	    private WebElement addToCartButton;

	     @FindBy(xpath="//u[normalize-space()='View Cart']")
	    private WebElement viewButton;
	    
	    @FindBy(xpath = "//div[@class='product-information']")
	    private WebElement productInfo;

	    
	    
      //Actions
	    public boolean areProductDetailsVisible( ) {
	        return productName.isDisplayed() && 
	               productCategory.isDisplayed() && 
	               productPrice.isDisplayed() && 
	               productAvailability.isDisplayed() && 
	               productCondition.isDisplayed() && 
	               productBrand.isDisplayed();
	    }
	              //First Product
	    public void addFirstProductToCart() {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(firstProductAddToCart).click().perform();
	    }
	    
	    public void openFirstProductDetails() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", firstProductAddToCart);
	    }
              
	             //Second Product
	    public void addSecondProductToCart() {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(secondProductAddToCart).click().perform();
	    }
               //Continue Shopping
	    public void clickContinueShopping() {
	        continueShoppingButton.click();
	    }

	    public void clickViewCart() {
	        viewCartButton.click();
	    }
                //Set Quantity
	    public void setQuantity(String qty) {
	    	
	    	//waitForProductDetailPage();   // page check
	        quantityInput.clear();
	        quantityInput.sendKeys(qty);
	        //Select qt= new Select(quantityInput);
	    }
              //Cart
	    public void addToCart() {
	        addToCartButton.click();
	    }
	    
	    public void clickView() {
	    	viewButton.click();
	    }
	    
	       ///Wait
	    public void waitForProductDetailPage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(productInfo));
	    }


}
