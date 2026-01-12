package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogedOut extends BaseClass{
	
	//Constructor
	 WebDriver driver;
	public LogedOut(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	//Locator
	
	@FindBy(xpath="//i[@class='fa fa-user']/following-sibling::b")
	WebElement LogedUserName;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement clkLogedOut;
	
	//Actions
	
	public String logedUser()
	{
		return LogedUserName.getText();
	}
	
	public void clickLogedOut()
	{
		clkLogedOut.click();
	}
	
}
