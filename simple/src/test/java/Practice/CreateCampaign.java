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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign extends BaseClass {
@Test
	public void createCampaign() throws Throwable {
		WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
 
 /*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
 Properties pro=new Properties();
 pro.load(fis);*/
        Property_Utility plib=new Property_Utility();
        
 
 /*String URL = pro.getProperty("url");
 String USERNAME = pro.getProperty("username");
 String PASSWORD = pro.getProperty("password");*/
        
        String URL = plib.getStringKeyAndValue("url");
        String USERNAME = plib.getStringKeyAndValue("username");
        String PASSWORD = plib.getStringKeyAndValue("password");
        driver.get(URL);
 
 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 driver.findElement(By.id("submitButton")).click();
 
 driver.findElement(By.linkText("More")).click();
 driver.findElement(By.name("Campaigns")).click();
 driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
 
 //Random ran=new Random();
 //int ranNum = ran.nextInt(1000);
 Java_Utility jlib=new Java_Utility();
 int ranNum = jlib.getRandomNum();
 
 FileInputStream fes=new FileInputStream("./src/test/resources/Excel2.xlsx");
 Workbook book = WorkbookFactory.create(fes);
 Sheet sheet = book.getSheet("Campaign");
 Row row = sheet.getRow(0);
 Cell cell = row.getCell(0);
 String Exceldata3 = cell.getStringCellValue()+ranNum;
 
 driver.findElement(By.name("campaignname")).sendKeys(Exceldata3);
 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 
 String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(actData.contains(Exceldata3))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
 WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 Actions act=new Actions(driver);
 act.moveToElement(data).perform();
 driver.findElement(By.linkText("Sign Out")).click();
	}

}
