package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class lib implements IAutoConstant{
	
	
	public static String getPropertyValue(String propertyName) {
		String propertyValue = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			 propertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {
			
		
		}
		return propertyValue;
		
	}
public static void captureScreenshot(WebDriver driver,String testMethodname)  {
		
		try {
			String currentdate = new Date().toString().replaceAll(":","_");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(SCREENSHOT_PATH+testMethodname+currentdate+".png");
			Files.copy(srcFile, destFile);
		} catch (Exception e) {
			
		}
		
	}

}
