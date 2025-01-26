package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
	
    WebDriver driver;  // not required
	//Constructor
	 public HomePage(WebDriver driver) {
		 
		 super(driver);
		 
	 }
	
	
	//Locators
	 @FindBy(how = How.XPATH , using = "//div[@id='top-links']//span[text()='My Account']")
	 WebElement myAccountLink;
	
	 @FindBy(xpath ="//div[@id='top-links']//a[text()='Login']")
	 WebElement loginLink;
	
	 @FindBy(xpath ="//div[@id='top-links']//a[text()='Register']")
	 WebElement registerLink;
	
	//Test Methods
	
	
	public void clickMyAccount() {
		
		myAccountLink.click();
	}
	
    public void clickLogin() {
		
	     loginLink.click();
	}
	
    public void clickRegister() {
		
    	registerLink.click();
	}
	
	
	

}
