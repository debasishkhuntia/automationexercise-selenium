package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BaseClass{

	//Constructor
	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	//Locators
	

	 @FindBy(xpath = "//h2[text()='Get In Touch']")
	    private WebElement getInTouchHeader;

	    @FindBy(xpath = "//input[@data-qa='name']")
	    private WebElement nameInput;

	    @FindBy(xpath = "//input[@data-qa='email']")
	    private WebElement emailInput;

	    @FindBy(xpath = "//input[@data-qa='subject']")
	    private WebElement subjectInput;

	    @FindBy(xpath = "//textarea[@data-qa='message']")
	    private WebElement messageInput;

	    @FindBy(xpath = "//input[@name='upload_file']")
	    private WebElement uploadFileInput;

	    @FindBy(xpath = "//input[@data-qa='submit-button']")
	    private WebElement submitButton;

	    @FindBy(xpath = "//div[@class='status alert alert-success']")
	    private WebElement successMessage;

	    @FindBy(xpath = "//a[@class='btn btn-success']")
	    private WebElement homeButton;
	    
	    
	    //Actions
	    
	    public boolean isGetInTouchVisible() {
	        return getInTouchHeader.isDisplayed();
	    }

	    public void fillContactForm(String name, String email, String subject, String message) {
	        nameInput.sendKeys(name);
	        emailInput.sendKeys(email);
	        subjectInput.sendKeys(subject);
	        messageInput.sendKeys(message);
	    }

	    public void uploadFile(String filePath) {
	        uploadFileInput.sendKeys(filePath);
	    }

	    public void clickSubmit() {
	        submitButton.click();
	    }

	    public void handleAlert() {
	        Alert alert = driver.switchTo().alert();
	        alert.accept(); // Clicks "OK" on the browser popup
	    }

	    public String getSuccessMessageText() {
	        return successMessage.getText();
	    }

	    public void clickHomeButton() {
	        homeButton.click();
	    }
	    

}
