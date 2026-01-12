package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {
	//CONSTRUCTOR
	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Autenerated constructor stub
		PageFactory.initElements(driver, this);
	}
	//LOCATOR
		 @FindBy(xpath="//input[@data-qa='signup-name']")
		   WebElement signupNameInput;
	
		  @FindBy(xpath = "//input[@data-qa='signup-email']")
		    private WebElement signupEmailInput;
		// 3. Signup Button
		    @FindBy(xpath = "//button[@data-qa='signup-button']")
		    private WebElement signupButton;

		    // 4. Header for verification ("New User Signup!")
		    @FindBy(xpath = "//div[@class='signup-form']/h2")
		    private WebElement signupHeader;
		    
		    @FindBy(xpath = "//div[@class='signup-form']/h2")
		    private WebElement newUserSignupHeader;
		    
		    
		 // --- Action Code (Methods) ---

		    /**
		     * Enters the name in the signup form.
		     * @param name The user's name
		     */
		    public void enterSignupName(String name) {
		        signupNameInput.clear();
		        signupNameInput.sendKeys(name);
		    }

		    /**
		     * Enters the email in the signup form.
		     * @param email The user's email address
		     */
		    public void enterSignupEmail(String email) {
		        signupEmailInput.clear();
		        signupEmailInput.sendKeys(email);
		    }
		    
		    public String getNewUserSignupHeaderText() {
		        return newUserSignupHeader.getText();
		    }
		    
		    public boolean isNewUserSignupVisible() {
		        return newUserSignupHeader.isDisplayed();
		    }
	}

