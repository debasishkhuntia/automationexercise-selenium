package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Page Object
	
	   @FindBy(xpath = "//tr[1]//td[@class='cart_description']")
	    WebElement firstProduct;

	    @FindBy(xpath = "//tr[2]//td[@class='cart_description']")
	    WebElement secondProduct;

	    @FindBy(xpath = "//tr[1]//td[@class='cart_price']")
	    WebElement firstProductPrice;

	    @FindBy(xpath = "//tr[2]//td[@class='cart_price']")
	    WebElement secondProductPrice;

	    @FindBy(xpath = "//tr[1]//td[@class='cart_quantity']")
	    WebElement firstProductQuantity;

	    @FindBy(xpath = "//tr[2]//td[@class='cart_quantity']")
	    WebElement secondProductQuantity;

	    @FindBy(xpath = "//tr[1]//td[@class='cart_total']")
	    WebElement firstProductTotal;

	    @FindBy(xpath = "//tr[2]//td[@class='cart_total']")
	    WebElement secondProductTotal;
	    
	    @FindBy(xpath = "//td[@class='cart_quantity']/button")
	    private WebElement cartQuantity;

	    
	    
	    //Actions
	    public boolean areProductsAdded() {
	        return firstProduct.isDisplayed() && secondProduct.isDisplayed();
	    }

	    public String getFirstProductPrice() {
	        return firstProductPrice.getText();
	    }

	    public String getSecondProductPrice() {
	        return secondProductPrice.getText();
	    }

	    public String getFirstProductQuantity() {
	        return firstProductQuantity.getText();
	    }

	    public String getSecondProductQuantity() {
	        return secondProductQuantity.getText();
	    }

	    public String getFirstProductTotal() {
	        return firstProductTotal.getText();
	    }

	    public String getSecondProductTotal() {
	        return secondProductTotal.getText();
	    }
	    
	    public String getProductQuantity() {
	        return cartQuantity.getText();
	    }



}
