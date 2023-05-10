package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver sdriver;	
public WebDriver driver;
public	Webdriver_Utility wlib=new Webdriver_Utility();
public Property_Utility plib=new Property_Utility();

	@BeforeSuite
	public void BS() {
		System.out.println("DataConnection");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass
	//public void BC() throws Throwable{
	public void BC() throws Throwable{
	//	WebDriver driver;
		String BROWSER = plib.getStringKeyAndValue("Browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		sdriver=driver;
		
		System.out.println("Launching the Browser");
	}
	
	@BeforeMethod
	public void BM() throws Throwable
	{
	//	WebDriver driver;
	
	        wlib.getWindowMax(driver);
	        wlib.getImplicityWait(driver);
	        
	       // Property_Utility plib=new Property_Utility();
	        String URL = plib.getStringKeyAndValue("url");
	        String USERNAME = plib.getStringKeyAndValue("username");
	        String PASSWORD = plib.getStringKeyAndValue("password");
	        driver.get(URL);
	        
	        LoginPage login=new LoginPage(driver);
	        login.loginToApp(USERNAME, PASSWORD);
	        
		System.out.println("Login to Application");
	}
	
	
	@AfterMethod
	public void AM() {
		System.out.println("Logout from Application");
	}
	@AfterClass
	public void AC() {
		System.out.println("close the browser");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("Database Closed");
	}
}
