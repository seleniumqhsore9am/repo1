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
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateLogin {
	
	
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
		
		Thread.sleep(5000);
		
		
		driver.quit();
		
	}
	
	
	@Test
	public void mouseHoverTest() throws InterruptedException, IOException
	{
		
		
		
		String currentDirectory=System.getProperty("user.dir");
		
		String excelDataPath=currentDirectory+"\\src\\test\\resources\\testdata\\excels\\LoginCredentials.xlsx";
		
		System.out.println(excelDataPath);
		
		FileInputStream f=new FileInputStream(new File(excelDataPath));
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		                          
		XSSFSheet ws=wb.getSheet("credentials");
		
		Iterator<Row> rows=ws.iterator();
		
		rows.next();
		
		Row row=null;
		
		while(rows.hasNext())
		{
			
			row=rows.next();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(row.getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(row.getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String actTitle=driver.getTitle();
		
		Assert.assertEquals(row.getCell(2).getStringCellValue(), actTitle);
		
		driver.navigate().back();
		
		}
		
		
		
		
	}
	

}
