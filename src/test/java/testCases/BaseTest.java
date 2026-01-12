package testCases;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;



public class BaseTest {
	
	
	 WebDriver driver;
	
	@Parameters({"browser","platform"})
	 @BeforeClass(groups={"sanity","regression"})
	public void setup(String browser,String platform) throws MalformedURLException
	{
		
		/*
        ChromeOptions options = new ChromeOptions();

        // Headless mode
        options.addArguments("--headless=new"); // Recommended for Chrome 109+
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options*/
		/*
		DesiredCapabilities  capabilities= new DesiredCapabilities();
		
		capabilities.setPlatform(Platform.LINUX);
		
		///////////////// Chrome Setup/////////////////////
		
		switch(browser.toLowerCase())
		{
			case "chrome":driver= new ChromeDriver(); break;
			case "firefox":driver= new FirefoxDriver(); break;
			case "edge":driver= new EdgeDriver(); break;
			default:System.err.println("Incorrect Browser ");return;
		}
		
		 driver = new RemoteWebDriver(
                 new URL("http://localhost:4444"),
                 capabilities
         );
         
         */
		
	     if (browser.equalsIgnoreCase("chrome")) {

	            ChromeOptions options = new ChromeOptions();
	            options.setPlatformName(platform); // linux
	            options.addArguments("--disable-gpu");
	            options.addArguments("--no-sandbox",
	                    "--disable-dev-shm-usage",
	                    "--disable-gpu",
	                    "--disable-extensions",
	                    "--disable-infobars",
	                    "--remote-allow-origins=*",
	                    "--window-size=1920,1080");
	            options.addArguments("--headless=new");

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options
	            );

	        } else if (browser.equalsIgnoreCase("firefox")) {

	            FirefoxOptions options = new FirefoxOptions();
	            options.setPlatformName(platform); // linux

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options
	            );

	        } else if (browser.equalsIgnoreCase("edge")) {

	            EdgeOptions options = new EdgeOptions();
	            options.setPlatformName(platform); // linux

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options
	            );

	        } else {
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
	}
	 
	@AfterClass(groups={"sanity","regression"})
	public void tearDown() throws InterruptedException
	{
		
		  if (driver != null) {
		        driver.quit();
		    }
		
	}
	


}
