package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class TC010_Subscription extends BaseTest {
	
	@Test(groups={"regression"})
	public void verifySubscription()
	{
		System.out.println("Test Case execution Started");
		 HomePage HP=new HomePage(driver);
		 
		 scrollToBottom();
		 
		 Assert.assertTrue(HP.isSubscriptionTextVisible(),"Subscription test is not Visible");
		 
		 HP.enterEmailAndSubscribe("test@gmail.com");
		 
		 Assert.assertTrue(HP.isSuccessMessageVisible(), "Success is not visible");
		 
		 System.out.println(HP.isSuccessMessageDisplay());
		 
		 System.out.println("Test case Executed successfully");
	}

	
	  private void scrollToBottom() {
		// TODO Auto-generated method stub
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}



}
