package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganisation;

	public WebElement getHomepage() {
		return organisationLink;
	}

	public WebElement getCreateOrganisation() {
		return createOrganisation;
	}
	public void organisationLinkClick() {
		organisationLink.click();
	}
	

}
