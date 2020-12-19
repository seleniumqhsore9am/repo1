package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import keywords.LoginKeywords;

public class ValidateLoginUsingKeywords extends BasePage{
	

	
	@Test
	public void validateLoginTest() throws InterruptedException, IOException
	{
		
		
		Iterator<Row> rows=ws.iterator();
		
		rows.next();
		
		LoginKeywords keys=new LoginKeywords();
		
		while(rows.hasNext())
		{
			
			String action=rows.next().getCell(3).getStringCellValue();
			
			if(action.equals("launchBrowser"))
			{
				keys.launchBrowser(pr1.getProperty("browser"));
				
			}
			else if(action.equals("navigateToURL"))
			{
				keys.navigateToURL(pr1.getProperty("url"));
				
			}
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(pr2.getProperty("username_textbox"),"reyaz009");
				
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword(pr2.getProperty("password_textbox"),"reyaz123");
				
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(pr2.getProperty("login_button"));
				
			}
		}
		
		
		
		
		
		
		
		
		
		
	}

}
