package generic;



import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.InetBanking.utilities.Xls_Reader;

public class BaseTest implements IAutoConstant {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static Logger logger;
	public static Xls_Reader excelreader = new Xls_Reader(EXCEL_PATH);
	public static Xls_Reader excelreaderCustDetails = new Xls_Reader(EXCEL_PATH_CUST_DETAILS);
	
	public BaseTest() {
		
	}
	public  void initilization() {
		driver = null;
		String browser = lib.getPropertyValue("BROWSER");
		logger = Logger.getLogger("BaseTest");
		PropertyConfigurator.configure("log4j.properties");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(lib.getPropertyValue("URLCRM"));
		
		
		
		
	}
	
	
	public void closeApplication(ITestResult res) {
		if (ITestResult.FAILURE==res.getStatus()) {
			lib.captureScreenshot(driver, res.getName());
			
		}
		
		//close the browser
		driver.quit();
		
		
	}
	
	
	public boolean isAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public static String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}

}
