package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import GenericUtility.Webdriver_Utility;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;
import POM_Repo.OrganizationCreationPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation extends BaseClass {
@Test
	public void createOrganization() throws Throwable{
//		String key="webdriver.edge.driver";
//	    String value="./src/main/resources/msedgedriver.exe";
//	    System.setProperty(key, value);
		//WebDriverManager.edgedriver().setup();
        //WebDriver driver=new EdgeDriver();
	WebDriver driver;
	Property_Utility plib=new Property_Utility();
	String BROWSER = plib.getStringKeyAndValue("Browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromiumdriver().setup();
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
//	
	
 
      /*  Webdriver_Utility wlib=new Webdriver_Utility();
        wlib.getWindowMax(driver);
        wlib.getImplicityWait(driver);*/
        
       
/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
 Properties pro=new Properties();
 pro.load(fis);
 
 String URL = pro.getProperty("url");
 String USERNAME = pro.getProperty("username");
 String PASSWORD = pro.getProperty("password");
 driver.get(URL);*/
       /*Property_Utility plib=new Property_Utility();
        String URL = plib.getStringKeyAndValue("url");
         String USERNAME = plib.getStringKeyAndValue("username");
        String PASSWORD = plib.getStringKeyAndValue("password");
        
        driver.get(URL);*/
 
 //driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 //driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 //driver.findElement(By.id("submitButton")).click();
    
    	//LoginPage login=new LoginPage(driver);
        //login.loginToApp(USERNAME, PASSWORD);
 
 //driver.findElement(By.linkText("Organizations")).click();
        HomePage home=new HomePage(driver);
        home.organisationLinkClick();
        
        OrganizationCreationPage1 org=new OrganizationCreationPage1(driver);
        org.clickOrganizationCreateImage();
 //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
 
 //Random ran=new Random();
 //int ranNum = ran.nextInt(1000);

 Java_Utility jlib=new Java_Utility();
 int ranNum = jlib.getRandomNum();
 
 /*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheet4.xlsx");
 Workbook book = WorkbookFactory.create(fes);
 Sheet sheet = book.getSheet("Organisation");
 Row row = sheet.getRow(0);
 Cell cell = row.getCell(0);
 String Exceldata2 = cell.getStringCellValue()+ranNum;*/
 
 Excel_Utility elib=new Excel_Utility();
 String Exceldata2 = elib.getExcelData("Organisation", 0, 0)+ranNum;
 //String phoneNum = elib.getExcelUsingDataFormatter("Organisation", 2, 0)+ranNum;
 
 org.organizationNameTextField(Exceldata2);
 
 //driver.findElement(By.name("accountname")).sendKeys(Exceldata2);
 Thread.sleep(1000);
// driver.findElement(By.id("phone")).sendKeys(phoneNum);
 
 org.saveButton();
// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 
	}

}
