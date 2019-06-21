package Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener extends TestListenerAdapter {
	ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest logger;

	public void onStart(ITestContext testContext) 
	{
		String timestap =new SimpleDateFormat("dd.mm.yyyy.HH.mm.ss").format(new Date());
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport"+testContext.getName()+timestap+".html");
		 htmlReporter.loadXMLConfig("./extent-config.xml");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "Localhost");
		 extent.setSystemInfo("Environment", "Automation Testing");
		 extent.setSystemInfo("User Name", "Santosh");
		 
		 htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		 htmlReporter.config().setReportName("Name of the Report Comes here");
		
		 htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public void onTestSuccess(ITestResult tr) 
	{
		 logger = extent.createTest("passTest");
		 Assert.assertTrue(true);
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
		 
	}
	
	public void onTestFailure(ITestResult tr) 
	{
		logger = extent.createTest("failTest");
		 Assert.assertTrue(false);
		 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName() + " - Test Case Failed", ExtentColor.RED));
		 String currentdate = new Date().toString().replaceAll(":","_");
		 String screenshotPath = ("./screenshots/"+tr.getName()+currentdate+".png");
		 File f = new File(screenshotPath);
		 if (f.exists()) {
			 try {
				logger.fail("screenshot is below"+logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	public void onTestSkipped(ITestResult tr) 
	{
		logger = extent.createTest("skipTest");
		 throw new SkipException("Skipping - This is not ready for testing ");
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
}


