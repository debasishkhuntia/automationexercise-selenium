package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC002_AccountRegistration extends BaseTest{
	

	@Test (groups="regression")
	void accountRegistration()
	{
		
		try {
			HomePage HP = new HomePage(driver);
			HP.clkloginSignup();
			System.out.println("Driver in HomePage = " + driver);
			
			AccountRegistrationPage ARP= new AccountRegistrationPage(driver);
			ARP.enterNames("Deba Nath");
			ARP.enteremail("deba8245@gmail.com");
			ARP.clkSignUp();
			ARP.ChkBoxMr();
			//ARP.Name("DKKKKK");
			ARP.Password("12345");
			ARP.selectDateOfBirth("21", "April", "1996");
			ARP.ChkNewsLetter();
			ARP.ChkOption();
			ARP.ChkFirstName("Deba");
			ARP.ChkLastName("Nath");
			ARP.txtCompany("Hello");
			ARP.txtAddress1("Add1");
			ARP.txtAddress2("Add2");
			ARP.txtState("Odisha");
			ARP.txtCity("Bbsr");
			ARP.txtZip();
			ARP.txtMob();
			
			System.out.println("Enter Click Button!!");
			ARP.clkCreateAcc();
			
			String accountCreate=ARP.act();
		    Assert.assertEquals(accountCreate, "ACCOUNT CREATED!");
		    
		    System.out.println("Account Has been created!!");
			ARP.clkAcctCreated();
			
			   System.out.println("Click on Account  Delete button!!");
			
			ARP.clkDeleteAcct();
		   System.out.println("Account Has been Deleted!!");
		}
		catch(Exception e){
			
			Assert.fail(e.getMessage());
		}
		
	}

}
