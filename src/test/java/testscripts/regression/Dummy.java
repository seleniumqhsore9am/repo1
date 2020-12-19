package testscripts.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dummy {
	
	
	@Test
	public void myTest()
	{
		
		WebDriver driver=new ChromeDriver();
		
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		
		
		
		
	}

}
