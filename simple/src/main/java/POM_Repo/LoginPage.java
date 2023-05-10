package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	

	public WebElement getUserTextField() {
		return userTextField;
	}

	

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void loginToApp(String username,String password) {
		userTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	

}
