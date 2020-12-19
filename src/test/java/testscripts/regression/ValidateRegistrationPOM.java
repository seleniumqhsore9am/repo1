package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.NewUserRegistrationPage;
import pages.SearchHotelPage;

public class ValidateRegistrationPOM extends BasePage{
	
	
	@Test
	public void validateLoginPOMTest()
	{
		
		
		HomePage homePage=new HomePage(driver);
		NewUserRegistrationPage newUserRegistrationPage=new NewUserRegistrationPage(driver);
		
		homePage.newUserLink();
		
		
		
		newUserRegistrationPage.verifyTitle(driver, "Adactin.com - New User Registration");
	}

}
