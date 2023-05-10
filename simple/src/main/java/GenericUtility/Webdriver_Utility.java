package GenericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Webdriver_Utility {
	
	public void getWindowMax(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void getImplicityWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void getPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void switchingWindow(WebDriver driver,String partialText)
	{
		 Set<String> allWin = driver.getWindowHandles();//org   //cont  //prd
	      Iterator<String> id = allWin.iterator();
	      
	      while(id.hasNext())
	      {
	    	  String wid = id.next();//org
	    	  driver.switchTo().window(wid);
	    	  String title = driver.getTitle();
	    	  
	    	  if(title.contains(partialText))
	    	  {
	    		  break;
	    	  }
	      }
	}
	      public void alertAccept(WebDriver driver) {
	    	  Alert alt = driver.switchTo().alert();
	    	  alt.accept();
	      }
	      public void alertDismiss(WebDriver driver)
	      {
	    	  Alert alt = driver.switchTo().alert();
	    	  alt.dismiss();
	      }
	}
	



