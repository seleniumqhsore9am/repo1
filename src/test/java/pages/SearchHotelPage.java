package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	
	public SearchHotelPage(WebDriver driver)
	{
		
		
		PageFactory.initElements(driver, this);
	}
		
	/*
	 * WebElement
	 * welcomeLabel=driver.findElement(By.xpath("Welcome to Adactin Group of Hotels"
	 * ));
	 */
	
	@FindBy(xpath="//tr/td[text()='Welcome to Adactin Group of Hotels']")
	WebElement welcomeLabel;
	
	public void verifyTitle(WebDriver driver,String expTitle)
	{
		
			
		Assert.assertEquals(driver.getTitle(), expTitle);
		
	}
	

}
