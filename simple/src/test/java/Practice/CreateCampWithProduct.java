package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;

public class CreateCampWithProduct extends BaseClass{
@Test
	public void createCampWithProduct() throws Throwable {
		 WebDriver driver=new EdgeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/* FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		 Properties pro=new Properties();
		 pro.load(fis);
		 
		 String URL = pro.getProperty("url");
		 String USERNAME = pro.getProperty("username");
		 String PASSWORD = pro.getProperty("password");
		 driver.get(URL);*/
		 
		 Property_Utility plib=new Property_Utility();
	        String URL = plib.getStringKeyAndValue("url");
	        String USERNAME = plib.getStringKeyAndValue("username");
	        String PASSWORD = plib.getStringKeyAndValue("password");
	        driver.get(URL);
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Products")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		 
		 
		 //Random ran=new Random();
		 //int ranNum = ran.nextInt(1000);
		 
		 Java_Utility jlib=new Java_Utility();
		 int ranNum = jlib.getRandomNum();
		 
		 FileInputStream fes=new FileInputStream("./src/test/resources/Excel.xlsx");
		 Workbook book = WorkbookFactory.create(fes);
		 Sheet sheet = book.getSheet("PRODUCT");
		 Row row = sheet.getRow(0);
		 Cell cell = row.getCell(0);
		 String Exceldata4 = cell.getStringCellValue()+ranNum;
		 
		 driver.findElement(By.name("productname")).sendKeys(Exceldata4);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 driver.findElement(By.linkText("More")).click();
		 driver.findElement(By.name("Campaigns")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		 
		 Random ran1=new Random();
		 int ranNum1 = ran1.nextInt(1000);
		 
		 FileInputStream fes1=new FileInputStream("./src/test/resources/Excel2.xlsx");
		 Workbook book1 = WorkbookFactory.create(fes1);
		 Sheet sheet1 = book1.getSheet("Campaign");
		 Row row1 = sheet1.getRow(0);
		 Cell cell1 = row1.getCell(0);
		 String Exceldata3 = cell1.getStringCellValue()+ranNum1;
		 driver.findElement(By.name("campaignname")).sendKeys(Exceldata3);
		 
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		 Set<String> allWin = driver.getWindowHandles();
		 Iterator<String> id = allWin.iterator();
		 while(id.hasNext())
		 {
			 String wid = id.next();
			 driver.switchTo().window(wid);
			 String title = driver.getTitle();
			 if(title.contains("Products&action"))
			 {
				 break;
			 }
		 }
		 driver.findElement(By.name("search_text")).sendKeys(Exceldata4);
		 driver.findElement(By.name("search")).click();
		 
		 //driver.findElement(By.xpath("//a[text()='IPHONE8876']")).click();
		 driver.findElement(By.xpath("//a[text()='"+Exceldata4+"']")).click();
		 //driver.findElement(By.xpath("//a[contains(text(),'"+Exceldata4+"']")).click();
		 
		 
		 Set<String> allWin1 = driver.getWindowHandles();
		 Iterator<String> id1 = allWin1.iterator();
		 while(id1.hasNext())
		 {
			 String wid1 = id1.next();
			 driver.switchTo().window(wid1);
			 String title1 = driver.getTitle();
			 if(title1.contains("Campaigns&action"))
			 {
				 break;
			 }
		 }
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			//Assert.assertEquals(actData, Exceldata4);
			if(actData.contains(Exceldata3))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			String actData1 = driver.findElement(By.id("dtlview_Product")).getText();
			
			if(actData1.contains(Exceldata4))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
	}

}
