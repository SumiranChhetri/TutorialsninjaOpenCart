package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver; // not required

	// Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(how = How.XPATH, using = "//div//input[@id='input-firstname']")
	WebElement txtfirstName;

	@FindBy(xpath = "//div//input[@id='input-lastname']")
	WebElement txtlastName;

	@FindBy(xpath = "//div//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//div//input[@id='input-telephone']")
	WebElement txttelephone;

	@FindBy(xpath = "//div//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//div//input[@id='input-confirm']")
	WebElement txtpasswordConfirm;

	@FindBy(xpath = "//div//input[@name='agree']")
	WebElement chkBoxagreePrivacyPolicy;

	@FindBy(xpath = "//div//input[@value='Continue']")
	WebElement continueBtn;
	
	
	
	@FindBy(xpath = "//div//h1[text()='Your Account Has Been Created!']")
	WebElement confirmationMessage;

	

	// Test Methods

	public void setFirstName(String name) {

		txtfirstName.sendKeys(name);
	}

	public void setLastName(String lname) {

		txtlastName.sendKeys(lname);

	}

	public void setEmail(String email) {
		
    	txtemail.sendKeys(email);
    	
	}
  
	public void setTelephoneNumber(String teleNum) {

		txttelephone.sendKeys(teleNum);
	}

	public void setPassword(String password) {

		txtpassword.sendKeys(password);
	}
	
	
	public void setConfirmPassword(String password) {  // password & confirm password value will be same so passing the same value

		txtpasswordConfirm.sendKeys(password);
	}
	
	
	public void setPrivacy() {

		chkBoxagreePrivacyPolicy.click();
	}
	
	public void clickContinue() {

		continueBtn.click();
	}
	
	
	public String getConfirmationMessage() {
		
		try {
			return confirmationMessage.getText();
		}
		catch (Exception e) {
			return (e.getLocalizedMessage());
		}		
	}
	
	
} // EOF Class
