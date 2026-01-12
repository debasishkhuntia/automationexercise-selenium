package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AccountRegistrationPage extends BaseClass{
	
	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Locator
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement sendNames;
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement sendEmails;
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement clickSignUp;
	
	@FindBy(xpath="//input[@value='Mr']")
	WebElement chkMr;
	@FindBy(xpath="//input[@value='Mrs']")
	WebElement chkMrs;
	
	

	@FindBy(xpath="//input[@name='name']")
	WebElement inName;
	@FindBy(xpath="//input[@name='email']")
	WebElement inEmail;
	@FindBy(xpath="//input[@name='password']")
	WebElement inPassword;
	
	

	@FindBy(xpath="//select[@name='months']")
	WebElement slcMonth;
	@FindBy(xpath="//select[@name='days']")
	WebElement slcDay;
	@FindBy(xpath="//select[@name='years']")
	WebElement slcYear;
	
	
	@FindBy(xpath="//input[@name='newsletter']")
	WebElement clkNewsletter;
	@FindBy(xpath="//input[@name='optin']")
	WebElement clkOption;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement sendFirstName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement sendLastName;
	@FindBy(xpath="//input[@name='company']")
	WebElement sendCompany;
	@FindBy(xpath="//input[@name='address1']")
	WebElement sendAddress1;
	@FindBy(xpath="//input[@name='address2']")
	WebElement sendAddress2;
	@FindBy(xpath="//input[@name='state']")
	WebElement sendState;
	@FindBy(xpath="//input[@name='city']")
	WebElement sendCity;
	@FindBy(xpath="//input[@name='zipcode']")
	WebElement sendZip;
	@FindBy(xpath="//input[@name='mobile_number']")
	WebElement sendMobile;
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement clkCreateAccount;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement AccountCreated;
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	WebElement AccountCreatedPage;
	
	@FindBy(xpath="//a[normalize-space()='Delete Account']")
	WebElement DeleteAccount;
	//Actions
	
	public void enterNames(String name)
	{
		sendNames.sendKeys(name);
	}
	public void enteremail(String email)
	{   
	    sendEmails.sendKeys(email);
	}
	public void clkSignUp()
	{   
		clickSignUp.click();
	}
	
	
	public void ChkBoxMr()
	{   
		chkMr.click();
	}
	public void ChkBoxMrs()
	{   
		chkMrs.click();
	}
	
	public void Name(String name)
	{   
		inName.sendKeys(name);
	}
	public void Password(String pwd)
	{   
		inPassword.sendKeys(pwd);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
        Select daySelect = new Select(slcDay);
        daySelect.selectByVisibleText(day);

        Select monthSelect = new Select(slcMonth);
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(slcYear);
        yearSelect.selectByVisibleText(year);
    }
	
	public void ChkNewsLetter()
	{   
		clkNewsletter.click();
	}
	public void ChkOption()
	{   
		clkOption.click();
	}

	
	public void ChkFirstName(String FirstName)
	{   
		sendFirstName.sendKeys(FirstName);
	}
	public void ChkLastName(String LastName)
	{   
		sendLastName.sendKeys(LastName);
	}
	
	public void txtCompany(String company)
	{   
		sendLastName.sendKeys(company);
	}
	public void txtAddress1(String add)
	{   
		sendAddress1.sendKeys(add);
	}
	public void txtAddress2(String add1)
	{   
		sendAddress2.sendKeys(add1);
	}
	public void txtState(String state)
	{   
		sendState.sendKeys(state);
	}
	public void txtCity(String city)
	{   
		sendCity.sendKeys(city);
	}
	public void txtZip()
	{   
		sendZip.sendKeys("751019");
	}
	public void txtMob()
	{   
		sendMobile.sendKeys("9337995616");
	}
	public void clkCreateAcc()
	{   
		clkCreateAccount.click();
	}
	  
	public String act()
	{
	return AccountCreatedPage.getText();
	}
	
	public void clkAcctCreated()
	{   
		AccountCreated.click();
	}
	public void clkDeleteAcct()
	{   
		DeleteAccount.click();
	}
	
	
	
}

