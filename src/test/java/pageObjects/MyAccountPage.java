package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	
	// constructor
	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	//locator
	@FindBy(xpath="//div[@id='content']//h2[contains(text(),'My Account')]")
	WebElement myAccountLabel;
	
	
	@FindBy(xpath="//ul[@class='list-inline']//li//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	//ul[@class='list-inline']//span[contains(text(),'My Account')]
	
	//test method
	public boolean isMyAccountPageExist() {
		try {
		return (myAccountLabel.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
		
		
	}
	
	public void logoutClick() {
		
		logoutLink.click();	
	}
	

}
