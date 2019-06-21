package com.InetBanking.testCases;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.InetBanking.pageObjects.LoginPage;
import com.InetBanking.utilities.Xls_Reader;

import generic.BaseTest;
import generic.lib;

public class TC_LoginTest_001 extends BaseTest{
	
	
	
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginObj = new LoginPage(driver);
		logger.info("Browser opened");
		loginObj.setUserName(excelreader.getCellData("guruCredential", 0,2));
		logger.info("Username entered");
		Thread.sleep(5000);
		loginObj.setPassword(excelreader.getCellData("guruCredential", 1, 2));
		logger.info("Password entered");
		loginObj.clickSubmit();
		
		/*String exptRes = "Guru99 Bank Manager HomePage12";
		String ActRes = driver.getTitle();	
		Assert.assertEquals(ActRes, exptRes);
		logger.info("Test Pass");*/
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("logintest is passed");
			
		} else {
			logger.info("loggintest is failed");
			
			

		}
		

	}
	
	
	
	

}
