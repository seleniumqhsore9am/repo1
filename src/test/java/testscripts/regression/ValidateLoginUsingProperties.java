package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLoginUsingProperties {
	
	
	
WebDriver driver;
	
	@BeforeMethod
	public void  setUp() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("properties\\environment.properties");
		
		Properties pr=new Properties();
		
		pr.load(fis);
		
		
		String browserToBeUsed=pr.getProperty("browser");
		
		if(browserToBeUsed.equals("chrome"))
		{
		
		driver=new ChromeDriver();
		}
		else if(browserToBeUsed.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		String urlToBeTested=pr.getProperty("url");
		
		driver.get(urlToBeTested);
		
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		
		Thread.sleep(5000);
		
		
		driver.quit();
		
	}
	
	
	@Test
	public void validateLoginTest() throws InterruptedException, IOException
	{
		
		FileInputStream fis=new FileInputStream("properties\\elementLocators.properties");
		
		Properties pr=new Properties();
		
		pr.load(fis);
		
		driver.findElement(By.xpath(pr.getProperty("username_textbox"))).sendKeys("reyaz009");
		
		driver.findElement(By.xpath(pr.getProperty("password_textbox"))).sendKeys("reyaz123");
		
		driver.findElement(By.xpath(pr.getProperty("login_button"))).click();
		
		
		
		
		
		
		
		
		
		
		
	}
}
