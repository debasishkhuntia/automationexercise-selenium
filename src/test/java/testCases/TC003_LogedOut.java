package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LogedOut;

public class TC003_LogedOut extends BaseTest{
	
	@Test(groups="sanity")
	public void verifyLogOut()
	{
		try {
			
			System.out.println("Driver = " + driver); 
			HomePage hp= new HomePage(driver);
			hp.clkloginSignup();
			
			System.out.println("Enter User Id And Password!!");
			LoginPage LP= new LoginPage(driver);
			LP.enterEmail("jan123@gmail.com");
			LP.enterPassword("jan123");
			LP.clkButton();
			System.out.println("Login Done");
			//System.out.println( LP.txtLogin());
			
			LogedOut LO= new LogedOut(driver);
		    String	validname=LO.logedUser();
			System.out.println("Logen in As:"+validname);
			LO.clickLogedOut();
			String validShow=LP.txtLogin();
			System.out.println("results: "+validShow);
			System.out.println("Loged Out Done Successfully!!");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); 
			e.printStackTrace();
		}
	}

}
