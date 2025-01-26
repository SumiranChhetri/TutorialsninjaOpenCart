package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

;

public class DataProviders {
	
    //@Test
    @DataProvider(name="logindata")
	public  Object[][] getloginData() throws IOException {
		
		String filepath = System.getProperty("user.dir")+"\\testData\\OpenCartLoginData.xlsx";
		ExcelUtility excelutility = new ExcelUtility(filepath);
		
		int totalrow = excelutility.getRowCount("TestSheet2");
		int totalcol = excelutility.getCellCount("TestSheet2", 1);
		System.out.println(totalrow+"  "+totalcol);
		
		String loginData[][] = new String[totalrow][totalcol];
		
		
		for (int i = 1; i <= totalrow; i++) {
			
			for (int j = 0; j < totalcol; j++) 
			{
				loginData[i-1][j] = excelutility.getCellData("TestSheet2", i, j); // i-1 becoz array start from 0 not 1 thats why 
				
			}
			
		}		
		return loginData;  
	}
}
