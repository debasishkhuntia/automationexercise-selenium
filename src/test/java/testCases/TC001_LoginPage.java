package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.LoginPage;

public class TC001_LoginPage extends BaseTest {
	@Test(groups="sanity")
	public void verifyLogin()
	{
		try
		{
			 System.out.println("Driver = " + driver); // MUST NOT BE NULL
			//Entering to Home Page on Page Object class
			HomePage HP=new HomePage(driver); 
			
			HP.clkloginSignup();
			
			
			LoginPage LP= new LoginPage(driver);
			System.out.println(LP.txtLogin());
			LP.enterEmail("jan123@gmail.com");
			LP.enterPassword("jan123");
			LP.clkButton();
			System.out.println("Login Successfully Done");
			//
		} 
		
		catch(Exception e)
		{
		
			System.out.println("Error while login");
			
			Assert.fail("my test fail", e);
			
		}
	}

}
