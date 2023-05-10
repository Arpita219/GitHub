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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {
@Test
	public void createProduct() throws Throwable {
		WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
 
 /*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
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
 
 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
 driver.findElement(By.linkText("Sign Out")).click();
	}

}
