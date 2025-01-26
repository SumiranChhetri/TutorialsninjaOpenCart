package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;



import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	  
     public static WebDriver driver; //making driver as common using the static keyword
     public Logger logger;
     public Properties properties;
     public FileInputStream fis;
     
	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException, URISyntaxException {
		
	 logger = LogManager.getLogger(this.getClass());
	 
	// Loading config.properties files
     String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
     fis = new FileInputStream(filepath);	 
	 properties = new Properties();
	 properties.load(fis);
	 
	 /* REMOTE or LOCAL execution code */
	 
	 // REMOTE
	 if(properties.getProperty("execution_env").equalsIgnoreCase("remote")){
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 // check the OS & Browser 
		 if(os.equalsIgnoreCase("windows"))
		 {
		 capabilities.setPlatform(Platform.WIN11);
		  }
		 else if(os.equalsIgnoreCase("mac"))
		 {
		 capabilities.setPlatform(Platform.MAC);
		  }
		 else if(os.equalsIgnoreCase("linux"))
		 {
		 capabilities.setPlatform(Platform.LINUX);
		  }
		 else {
			 System.out.println("No matching OS..");
		 }
		 
		 // BROWER....
		 switch(br.toLowerCase()){
		 case "chrome": capabilities.setBrowserName("chrome"); break;
		 case "edge": capabilities.setBrowserName("microsoftedge"); break;
		 case "firefox": capabilities.setBrowserName("firefox"); break;
		 default: System.out.println("No matching browser"); return;
		 }
		 
		 //String hubpath = properties.getProperty("huburl"+"/wd/hub");
		 URL url = new URI("http://192.168.0.105:4444/wd/hub").toURL();
		 driver = new RemoteWebDriver(url,capabilities);
		 
	 } // End of IF for REMOTE
	 
	 
	 
	// LOCAL
	 if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
	 {
                switch(br.toLowerCase()){
                case "chrome" : driver = new ChromeDriver(); break;
                case "firefox" : driver = new FirefoxDriver(); break;
                case "edge" : driver = new EdgeDriver(); break;
                default: System.out.println("Invalid Browser name ...");
	            }//END oF SWITCH
	 } // End of IF for Local 
	 
	 
	 
//     // Loading config.properties files
//     String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
//     fis = new FileInputStream(filepath);
    
    
     
     String appurl = properties.getProperty("url"); // Storing the url value from the properties file
		
    // driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.get(appurl);
     driver.manage().window().maximize(); 		
	}
	

	@AfterClass(groups= {"Regression","Sanity","Master"})
	  public void tearDown() {		
		driver.quit();
	}
	
	
      public String randomString() {		
		String randString = RandomStringUtils.randomAlphabetic(7);
		return randString;
		
	}
	
     public String randomInteger() {		
		String randNumber = RandomStringUtils.randomNumeric(10);
		return randNumber;
		
	}
     
     
     public String randomAlphanumeric() { 		
 		String randalpha = RandomStringUtils.randomAlphabetic(3);
 		String randnumeric = RandomStringUtils.randomNumeric(3);
 		return (randalpha+"#!@"+randnumeric);
 		
 	}
     
     
     public String captureScreen(String tname) throws IOException {
    	 
    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
 				
 		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
 		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
 		
 		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
 		File targetFile=new File(targetFilePath);
 		
 		sourceFile.renameTo(targetFile);
 			
 		return targetFilePath;

 	}

}
