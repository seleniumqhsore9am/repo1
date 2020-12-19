package testscripts.regression;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

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

public class ValidateLoginUsingDataProvider {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void  setUp()
	{
		
		driver=new ChromeDriver();
		
		
		driver.get("http://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
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
		
		Assert.assertEquals(expTitle,actTitle);
		
				
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		
		Object[][] obj=new Object[4][3];
		
		//set1 with 3 argumnets
		
		obj[0][0]="reyaz009";
		obj[0][1]="reyaz123";
		obj[0][2]="Adactin.com - Search Hotel";
		
		//set2 with 3 argumnets
		
				obj[1][0]="reyaz009";
				obj[1][1]="reyaz456";
				obj[1][2]="Adactin.com - Hotel Reservation System";
				
				//set3 with 3 argumnets
				
				obj[2][0]="reyaz123";
				obj[2][1]="reyaz456";
				obj[2][2]="Adactin.com - Hotel Reservation System";
				
				//set3 with 3 argumnets
				
				obj[3][0]="reyaz456";
				obj[3][1]="reyaz123";
				obj[3][2]="Adactin.com - Hotel Reservation System";
		
		
		
		
		
		
		
		return obj;
		
		
	}
	

}
