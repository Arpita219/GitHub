package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage1 {
	
	public OrganizationCreationPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter Methods
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickOrganizationCreateImage()
	{
		organizationCreateImage.click();
	}
	public void  organizationNameTextField(String orgName)
	{
		organizationNameTextField.sendKeys(orgName);
	}
public void saveButton() {
	saveButton.click();
}
}
