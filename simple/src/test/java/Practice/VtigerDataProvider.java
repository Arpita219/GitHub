package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerDataProvider {
	
	
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phoneNum,String Email) throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String BROWSER=plib.getStringKeyAndValue("Browser");
		WebDriver driver;
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
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        
        
        driver.findElement(By.name("accountname")).sendKeys(name);
        driver.findElement(By.id("phone")).sendKeys(phoneNum);
        driver.findElement(By.id("email1")).sendKeys(Email);
        driver.findElement(By.name("button")).click();
        Thread.sleep(1000);
   
        
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.quit();
        Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Random ran=new Random();
		int randmn=ran.nextInt(1000);
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="AAAA"+randmn;
		objArr[0][1]="9123456781";
		objArr[0][2]="abcd@gmail.com";
		
		
		objArr[1][0]="BBBB"+randmn;
		objArr[1][1]="987654321";
		objArr[1][2]="efgh@gmail.com";
		
		objArr[2][0]="CCCC"+randmn;
		objArr[2][1]="987654221";
		objArr[2][2]="ijkl@gmail.com";
		
		return objArr;
		
	}
	

}
