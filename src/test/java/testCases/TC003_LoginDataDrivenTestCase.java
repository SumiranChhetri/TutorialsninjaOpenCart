package testCases;

import java.util.Properties;

/* ******************* SCENARIO*************************
 * 
 * valid data - login success - test pass - click logout 
 * valid data - login unsuccessful - test fail  
 * 
 * invalid data - login success - test failed - click logout 
 * invalid data - login unsuccessful - test pass
 * 
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTestCase extends BaseClass{
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	//Properties properties;
	
	
	@Test(dataProvider ="logindata", dataProviderClass = DataProviders.class, groups="Datadriven") // data provider method specified in different DataProviders class to extra parm set
	public void verifyLoginDDT(String email , String password , String expectedResult ) {
		
	try {	
	 logger.info("************Starting TC002_LoginTestCase***********");
	 // Home page
	 hp = new HomePage(driver);
	 hp.clickMyAccount();
	 hp.clickLogin();
	 
	 //Login Page
	 lp = new LoginPage(driver);
	 lp.setEmail(email);	 
	 lp.setPassword(password);
	 lp.clickLogin();
	 
	 // My Account Page
	  mp= new MyAccountPage(driver);
	  boolean flag = mp.isMyAccountPageExist();
	  
	  
	  /* ******************* SCENARIO*************************
	   * 
	   * valid data - login success - test pass - click logout 
	   * valid data - login unsuccessful - test fail  
	   * 
	   * invalid data - login success - test failed - click logout 
	   * invalid data - login unsuccessful - test pass
	   * 
	   */
	  
	  if(expectedResult.equalsIgnoreCase("Valid"))
	  {
		  if(flag==true) {
			  hp.clickMyAccount();
			  mp.logoutClick();
			  Assert.assertTrue(true);
			  
		  }
		  else {
			  Assert.assertTrue(false);
		  }
		  
	  }
	  
	  if(expectedResult.equalsIgnoreCase("InValid"))
	  {
		  if(flag==true) {
			  hp.clickMyAccount();
			  mp.logoutClick();
			  Assert.assertTrue(false);
			  
		  }
		  else {
			  Assert.assertTrue(true);
		  }
		  
	  }	 
	  
    }// End of TRY block 
	
	  catch(Exception e) {
		  Assert.fail();
	  }// End of CATCH block 
	
	 logger.info("************Finished TC002_LoginTestCase***********");
	  
	}
	

}
