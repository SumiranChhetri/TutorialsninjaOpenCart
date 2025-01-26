package testCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass{
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	//Properties properties;
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		
	try {	
	 logger.info("************Starting TC002_LoginTestCase***********");
	 // Home page
	 hp = new HomePage(driver);
	 hp.clickMyAccount();
	 hp.clickLogin();
	 
	 //Login Page
	 lp = new LoginPage(driver);
	 lp.setEmail(properties.getProperty("email"));
	 lp.setPassword(properties.getProperty("password"));
	 lp.clickLogin();
	 
	 // My Account Page
	  mp= new MyAccountPage(driver);
	  boolean flag = mp.isMyAccountPageExist();
	  Assert.assertTrue(flag); 
	//  Assert.assertEquals(flag, true, "Login Failed....");
	 
	  logger.info("************Finished TC002_LoginTestCase***********");
	  
	  }
	  catch(Exception e) {
		  Assert.fail();
	  }
	  
	}
	

}
