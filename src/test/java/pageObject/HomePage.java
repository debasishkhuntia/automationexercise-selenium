package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{

	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement clkLoginSignup;
	
	
	@FindBy(xpath="//a[normalize-space()='Contact us']")
	WebElement contactUs;
	
	@FindBy(xpath="//a[contains(text(),'Test Cases')]")
	WebElement testCasesButton;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement products;
	
	  // Subscription section
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    WebElement emailInput;

    @FindBy(id = "subscribe")
    WebElement subscribeBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successMessage;
	
	//Actions
	
	public void clkloginSignup()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(clkLoginSignup));
	    clkLoginSignup.click();
	}
	public void clkContactUs()
	{
		contactUs.click();
	}
	
	public void clickTestCases() {
        testCasesButton.click();
        
	}
	public void clickProducts() {
		products.click();
        
	}
	
	///Subscription  Action Section
	  public boolean isSubscriptionTextVisible() {
	        return subscriptionText.isDisplayed();
	    }

	    public void enterEmailAndSubscribe(String email) {
	        emailInput.sendKeys(email);
	        subscribeBtn.click();
	    }

	    public boolean isSuccessMessageVisible() {
	        return successMessage.isDisplayed();
	    }
	    public String isSuccessMessageDisplay()
	    {
	    	return successMessage.getText();
	    }
	
	 
	
	
	
}
