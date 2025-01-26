package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	
	//WebDriver driver;
	AccountRegistrationPage arp;
	HomePage hp;
	
//	@BeforeClass  /// this is coming from the baseclass
//	public voiud setUp() {
//     driver = new ChromeDriver();
//     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//     driver.get("https://tutorialsninja.com/demo/");
//     driver.manage().window().maximize(); 		
//	}
	
	@Test(groups={"Regression","Master"})
	public void verifyAccountRegistration() throws InterruptedException {
		logger.info("****Starting TC001_AccountRegistration****");
	  
		try {
		
        hp=new HomePage(driver);	
		hp.clickMyAccount();
		logger.info("****clicked on the My Account link****");
		Thread.sleep(2000);
		hp.clickRegister();
		logger.info("****clicked on the Register link****");
       
		arp = new AccountRegistrationPage(driver);
		
		// Storing a password 
		String password = randomString();
		logger.info("***Providing customer details****");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephoneNumber(randomInteger());
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		arp.setPrivacy();
		arp.clickContinue();
		
		logger.info("****Click on the Continue button****");
		
		Thread.sleep(2000);
		String message = arp.getConfirmationMessage();
		
		if(message.equals("Your Account Has Been Created!")) 
		{
		Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
			logger.error("Test failed ..");
			//logger.debug("Debug logs ..");
		}
		
		logger.info("****Validated that customer has been created ****");
		
		} //End of TRY Block 
		
		
		catch(Exception e) {			
			Assert.fail();			
		} //End of CATCH block
		
		
		logger.info("****Finished TC001_AccountRegistration****");	
	}
}	
	
//	@AfterClass
//	public void tearDown() {
//		
//		driver.quit();
//	}
//	
//	
//	public String randomString() {
//		
//		String randString = RandomStringUtils.randomAlphabetic(7);
//		return randString;
//		
//	}
//	
//     public String randomInteger() {
//		
//		String randNumber = RandomStringUtils.randomNumeric(10);
//		return randNumber;
//		
//	}
//     
//     
//     public String randomAlphanumeric() {
// 		
// 		String randalpha = RandomStringUtils.randomAlphabetic(3);
// 		String randnumeric = RandomStringUtils.randomNumeric(3);
// 		return (randalpha+"#!@"+randnumeric);
// 		
// 	}


