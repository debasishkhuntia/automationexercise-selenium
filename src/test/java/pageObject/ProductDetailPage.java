package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
      //Actions
	    public boolean areProductDetailsVisible( ) {
	        return productName.isDisplayed() && 
	               productCategory.isDisplayed() && 
	               productPrice.isDisplayed() && 
	               productAvailability.isDisplayed() && 
	               productCondition.isDisplayed() && 
	               productBrand.isDisplayed();
	    }

}
