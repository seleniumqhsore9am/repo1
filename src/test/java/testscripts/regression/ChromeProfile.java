package testscripts.regression;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeProfile {
	
	public static void main(String[] args) {
		
		
		
		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome(); String
		 * chromeProfile =
		 * "C:\\Users\\LUCKY\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Google Profile.ico"
		 * ; ArrayList<String> switches = new ArrayList<String>();
		 * switches.add("--user-data-dir=" + chromeProfile);
		 * capabilities.setCapability("chrome.switches", switches); WebDriver driver =
		 * new ChromeDriver(capabilities); driver.get("http://www.google.com");
		 */
		
		String userProfile= "C:\\Users\\LUCKY\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir="+userProfile);
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.google.com");
	}

}
