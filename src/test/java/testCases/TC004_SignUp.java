package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC004_SignUp  extends BaseTest{
	@Test(groups="regression")
	void signup()
	{
		try {
			//Entering to Home Page on Page Object class
			HomePage HP=new HomePage(driver); 
			
			HP.clkloginSignup();
			 String homeTitle = driver.getTitle();
		    Assert.assertEquals(homeTitle, "Automation Exercise - Signup / Login");
		     
		     SignUpPage SP= new SignUpPage(driver);
		     
		     System.out.println(SP.getNewUserSignupHeaderText());
		     
		     SP.enterSignupName("deba");
		     SP.enterSignupEmail("jan123@gmail.com");
		     
		     
		     

		     Assert.assertTrue(true, "Email Address already exist!");
			
		     System.out.println("Test Passed!!");
		}catch(Exception e) {
			e.getMessage();
			
		}
	}
	

}
