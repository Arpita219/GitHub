package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import POM_Repo.HomePage;
import POM_Repo.OrganizationCreationPage1;
//@Listeners(GenericUtility.ListenerImp.class)
public class practice extends BaseClass {
	@Test(retryAnalyzer = GenericUtility.RetryAnalyserImple.class)
	//@Test

	public void Practice() throws Throwable {
		 
		 
//		 Property_Utility plib=new Property_Utility();
	     Java_Utility jlib=new Java_Utility();
	     Excel_Utility elib=new Excel_Utility();
	     HomePage home=new HomePage(driver);
	     OrganizationCreationPage1 org=new OrganizationCreationPage1(driver);
	     home.organisationLinkClick();
	     org.clickOrganizationCreateImage();
	     Assert.assertEquals(false, true);
	     int ranNum = jlib.getRandomNum();
	     String Exceldata2 = elib.getExcelData("Organisation", 0, 0)+ranNum;
	     org.organizationNameTextField(Exceldata2);
	     Thread.sleep(1000);
	     org.saveButton();
			 
	}

}
