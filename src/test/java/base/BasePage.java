package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasePage {
	
	public static WebDriver driver;
	protected FileInputStream fis1;
	protected Properties pr1;
	protected FileInputStream fis2;
	protected Properties pr2;
	protected FileInputStream fis3;
	protected XSSFWorkbook wb;
	protected XSSFSheet ws;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	
	@BeforeClass
	public void fileSetUp() throws IOException
	{
		
		

		fis1=new FileInputStream("properties\\environment.properties");
		
		pr1=new Properties();
		
		pr1.load(fis1);
		
		
		fis2=new FileInputStream("properties\\elementLocators.properties");
		
		pr2=new Properties();
		
		pr2.load(fis2);
		
		fis3=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginKeywords.xlsx");
		
		
		wb=new XSSFWorkbook(fis3);
		
		
		ws=wb.getSheet("Sheet1");
		
		

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcDir=new File(System.getProperty("user.dir")+"\\reports");
		
		
		srcDir.mkdir();
		
		File path=new File(System.getProperty("user.dir")+"\\reports\\"+date+".html");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		
		reporter.config().setDocumentTitle("Test Regression Results");
		
		reporter.config().setReportName("Adactin Hotel app Regression Test");
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Reyaz");
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		
		String b=pr1.getProperty("browser");
		
		if(b.equals("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if(b.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		driver.get(pr1.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
				
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		
		
		
		driver.quit();
	}
	
	
	@AfterClass
	public void flushReports()
	{
		
		extent.flush();
	}
	

}
