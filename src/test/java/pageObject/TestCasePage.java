package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage extends HomePage {

	public TestCasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
		
	}
	//locator
			@FindBy(xpath="//b[normalize-space()='Test Cases']")
			WebElement txtTestCase; 
			
			
			//actions
			public String getTestCaseHeaderText() {
		        return txtTestCase.getText();
		    }

}
