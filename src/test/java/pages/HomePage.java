package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	
	public HomePage(WebDriver driver)
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	
		
	/*
	 * WebElement
	 * username=driver.findElement(By.xpath("//input[@name='username']"));
	 * 
	 * WebElement
	 * password=driver.findElement(By.xpath("//input[@name='username']"));
	 * 
	 * WebElement login=driver.findElement(By.xpath("//input[@name='username']"));
	 */
	
	
	@FindBy(xpath="//input[@name='username']") 
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']") 
	WebElement login;
	
	@FindBy(xpath="//a[text()='New User Register Here']")
	WebElement newUserLink;
	
	public void newUserLink()
	{
		newUserLink.click();
	}
	
	
	/*
	 * username.sendKeys(keysToSend);
	 * 
	 * password.sendKeys(keysToSend);
	 * 
	 * login.click();
	 */
	
	public void login(String un,String pass)
	{
		
		  username.sendKeys(un);
		  
		  password.sendKeys(pass);
		  
		  login.click();
		 
		
	}
	

}
