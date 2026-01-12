package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ContactUsPage;
import pageObject.HomePage;

public class TC005_ContactUsPage extends BaseTest{
	@Test(groups="regression")
	void contactUs()
	{
		try {
			HomePage hompage= new HomePage(driver);
			hompage.clkContactUs();
			
			//Contact Us Page
			ContactUsPage CUP= new ContactUsPage(driver);
			
			Assert.assertTrue(CUP.isGetInTouchVisible(), "GET IN TOUCH");
			System.out.println("GET IN TOUCH");
			CUP.fillContactForm("deba",
					"ja123@gmail.com",
					"Hello",
					"Hi I am Deba");
			
			
			String filePath = System.getProperty("user.dir") + "/src/test/resources/image (11).png";
		
			CUP.uploadFile(filePath);
			
			CUP.clickSubmit();
			CUP.handleAlert();
			
			 String successMessage=CUP.getSuccessMessageText();
			
			 Assert.assertEquals(successMessage, "Success! Your details have been submitted successfully.");
		
			 System.out.println("Success! Your details have been submitted successfully.");
		    CUP.clickHomeButton();
		  //Contact Us Page Ended
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
