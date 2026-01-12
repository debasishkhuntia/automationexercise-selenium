package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.TestCasePage;

public class TC006_TestCases  extends BaseTest{
	@Test
	void TestCaseClick()
	{
		try
		{
			HomePage hp= new HomePage(driver);
			hp.clickTestCases();
			TestCasePage tp= new TestCasePage(driver);
			System.out.println(tp.getTestCaseHeaderText()); 
			
		}catch(Exception e)
		{
			e.getMessage();
		}
	}

}
