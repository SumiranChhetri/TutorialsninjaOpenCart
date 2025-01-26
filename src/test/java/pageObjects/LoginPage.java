package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//Constructor
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	// Locators
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	//Test Methods
	
	
	public void setEmail(String email) {
		loginEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		loginPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
}
