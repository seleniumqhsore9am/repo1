package testscripts.regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.SearchHotelPage;

public class ValidateLoginPOM extends BasePage{
	
	
	@Test(dataProvider="getData")
	public void validateLoginPOMTest(String un,String pass,String expTitle)
	{
		
		
		HomePage homePage=new HomePage(driver);
		SearchHotelPage searchHotelPage=new SearchHotelPage(driver);
		
		
		homePage.login(un, pass);
		
		
		
		searchHotelPage.verifyTitle(driver,expTitle);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		String currentDirectory=System.getProperty("user.dir");
		
		String excelDataPath=currentDirectory+"\\src\\test\\resources\\testdata\\excels\\LoginCredentials.xlsx";
		
		System.out.println(excelDataPath);
		
		FileInputStream f=new FileInputStream(new File(excelDataPath));
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		                          
		XSSFSheet ws=wb.getSheet("credentials");
		
		
			
		
		Object[][] obj=new Object[ws.getLastRowNum()][3];
		
		for(int i=0,j=1;i<ws.getLastRowNum();i++,j++)
		{
								
			for(int k=0;k<3;k++)
			{
				
				obj[i][k]=ws.getRow(j).getCell(k).getStringCellValue();
			}
			
		}
		
		
		
		
		
		
		
		
		return obj;
		
		
	}
	

}
