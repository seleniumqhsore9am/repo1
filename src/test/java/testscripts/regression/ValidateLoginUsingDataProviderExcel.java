package testscripts.regression;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateLoginUsingDataProviderExcel {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void  setUp()
	{
		
		driver=new ChromeDriver();
		
		
		driver.get("http://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		
		//Thread.sleep(5000);
		
		
		driver.quit();
		
	}
	
	
	@Test(dataProvider="getData")
	public void mouseHoverTest(String un,String pass,String expTitle) throws InterruptedException, IOException
	{
		
		
		
		
		
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String actTitle=driver.getTitle();
		
		Assert.assertEquals(expTitle ,actTitle);
		
		
		
		
		
		
		
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
