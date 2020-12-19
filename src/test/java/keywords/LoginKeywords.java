package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginKeywords {
	
	protected WebDriver driver;
	
	public void launchBrowser(String b)
	{
		
		
		
		if(b.equals("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if(b.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
	}
	
	
	public void navigateToURL(String url)
	{
		
		driver.get(url);
		
		
	}
	
	
	public void enterUsername(String loc,String un)
	{
		
		driver.findElement(By.xpath(loc)).sendKeys(un);
	}
	
	public void enterPassword(String loc,String pass)
	{
		
		driver.findElement(By.xpath(loc)).sendKeys(pass);
	}
	
	
	public void clickLogin(String loc)
	{
		
		driver.findElement(By.xpath(loc)).click();
		
	}
	
	
	

}
