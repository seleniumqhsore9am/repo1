package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistrationPage {
	
	public NewUserRegistrationPage(WebDriver driver)
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyTitle(WebDriver driver,String expTitle)
	{
		
			
		Assert.assertEquals(driver.getTitle(), expTitle);
		
	}

}
