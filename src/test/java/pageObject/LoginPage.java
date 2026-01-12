package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {
	
	//Constructor
	public LoginPage(WebDriver driver){
		
		super(driver);
		
		PageFactory.initElements(driver, this);
		
	}
	//Locators
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement keysLogin;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement keysPassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement btnsLogin;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")
	WebElement txtLoginPage;
	
	//Actions
	public void enterEmail(String email)
	{
		keysLogin.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		keysPassword.sendKeys(password);
	}
	public void clkButton()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.elementToBeClickable(btnsLogin)).click();
	}
	public String txtLogin()
	{
		return txtLoginPage.getText();
	}
	

}
