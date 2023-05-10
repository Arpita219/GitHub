package Practice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import GenericUtility.Webdriver_Utility;

public class CreateProductDeleteProduct {

	public static void main(String[] args) throws Throwable {
		 WebDriver driver=new EdgeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
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
		 Webdriver_Utility wlib=new Webdriver_Utility();
		 wlib.getImplicityWait(driver);
		 
		 driver.findElement(By.linkText("Products")).click();
		 //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+Exceldata4+"']/../preceding-sibling::td[2]")).click();
		 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+Exceldata4+"']/../preceding-sibling::td[2]")).click();
		 
		// driver.findElement(By.id("25")).click();
		 driver.findElement(By.xpath("//input[@value='Delete']")).click();
		 
		/* Alert alt = driver.switchTo().alert();
		 alt.accept();*/
		 
		 Webdriver_Utility dlib=new Webdriver_Utility();
		 dlib.alertAccept(driver);
		 
		 
		  List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		  
		  boolean flag=false;
		  for(WebElement wb:lists)
		  {
			  String act=wb.getText();
			  if(act.contains(Exceldata4))
			  {
				  flag=true;
				  break;
				  
			  }
		  }
if(flag)
{
	System.out.println("deleted");
}
else
{
	System.out.println("not deleted");
}
		 
		 
	}

}
