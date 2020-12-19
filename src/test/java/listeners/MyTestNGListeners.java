package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BasePage;

public class MyTestNGListeners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcDir=new File(System.getProperty("user.dir")+"\\srceenshots");
		
		
		srcDir.mkdir();
		
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		
		
		File destFile=new File(System.getProperty("user.dir")+"\\srceenshots\\"+testName+date+".png");
		
		
		try {
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		String testName=result.getMethod().getMethodName();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcDir=new File(System.getProperty("user.dir")+"\\srceenshots");
		
		
		srcDir.mkdir();
		
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		
		
		File destFile=new File(System.getProperty("user.dir")+"\\srceenshots\\"+testName+date+".png");
		
		
		
		try {
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
