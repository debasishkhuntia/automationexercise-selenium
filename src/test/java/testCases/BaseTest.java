package testCases;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;



public class BaseTest {
	
	
	 WebDriver driver;
	 public  Logger logger = LogManager.getLogger(this.getClass());
	 public  Properties properties;
	
	@Parameters({"browser","platform"})
	 @BeforeClass(groups={"sanity","regression"})
	public void setup(String browser,String platform) throws IOException
	{ 
		
		//LOAD CONFIG PROPERTIES FILE
		
		FileReader	file=new FileReader("./src//test//resources//cofig.properties");
		
		properties =new Properties();//create object Of Properties
		properties.load(
			    getClass()
			        .getClassLoader()
			        .getResourceAsStream("cofig.properties")
			);/// load file into properties object
		
		
		///
		/// LOCAL MODE
		if(properties.getProperty("execution_env").equalsIgnoreCase("local")) {
        ChromeOptions options = new ChromeOptions();

        // Headless mode
        options.addArguments("--headless=new"); // Recommended for Chrome 109+
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options
		
		//DesiredCapabilities  capabilities= new DesiredCapabilities();
		
		//capabilities.setPlatform(Platform.LINUX);
		
		///////////////// Chrome Setup/////////////////////
     
		switch(browser.toLowerCase())
		{
			case "chrome":driver= new ChromeDriver(); break;
			case "firefox":driver= new FirefoxDriver(); break;
			case "edge":driver= new EdgeDriver(); break;
			default:System.out.println("Incorrect Browser ");return;
		}
		
		/* driver = new RemoteWebDriver(
                 new URL("http://localhost:4444"),
                 capabilities
         );
         */
		   driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		}
		////REOMTE DRIVER
		
		else if(properties.getProperty("execution_env").equalsIgnoreCase("remote")) {	
		
	     if (browser.equalsIgnoreCase("chrome")) {

	            ChromeOptions options1 = new ChromeOptions();
	            options1.setPlatformName(platform); // linux
	            options1.addArguments("--disable-gpu");
	            options1.addArguments("--no-sandbox",
	                    "--disable-dev-shm-usage",
	                    "--disable-gpu",
	                    "--disable-extensions",
	                    "--disable-infobars",
	                    "--remote-allow-origins=*",
	                    "--window-size=1920,1080");
	            options1.addArguments("--headless=new");

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options1
	            );

	        } else if (browser.equalsIgnoreCase("firefox")) {

	            FirefoxOptions options1 = new FirefoxOptions();
	            options1.setPlatformName(platform); // linux

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options1
	            );

	        } else if (browser.equalsIgnoreCase("edge")) {

	            EdgeOptions options1 = new EdgeOptions();
	            options1.setPlatformName(platform); // linux

	            driver = new RemoteWebDriver(
	                    new URL("http://localhost:4444"),
	                    options1
	            );

	        } else {
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
	     driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
	     }
		
		
		
	}
	
	 
	@AfterClass(groups={"sanity","regression"})
	public void tearDown() throws InterruptedException
	{
		
		  if (driver != null) {
		        driver.quit();
		    }
		
	}
	


}
