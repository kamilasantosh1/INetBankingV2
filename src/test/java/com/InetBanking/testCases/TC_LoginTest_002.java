package com.InetBanking.testCases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;

import generic.BaseTest;

public class TC_LoginTest_002 extends BaseTest {
	@Test(dataProvider="LoginData")
	public void loginTestUsingExcel(String usr, String pwd) throws InterruptedException {
		LoginPage loginObj = new LoginPage(driver);
		logger.info("Browser opened");
		loginObj.setUserName(usr);
		logger.info("Username entered");
		
		loginObj.setPassword(pwd);
		logger.info("Password entered");
		Thread.sleep(3000);
		loginObj.clickSubmit();
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			logger.warn("login failed");
			
		} else {
			
			logger.info("login pass");
			Thread.sleep(3000);
			loginObj.clickLogoutBtn();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}
		
	}
	@DataProvider(name="LoginData")
	String [][]getData(){
		int rowCount = excelreader.getRowCount("guruCredential");
		int columnCount = excelreader.getColumnCount("guruCredential");
		String [][]LoginData = new String[rowCount][columnCount];
		for (int rownum =2; rownum <rowCount ; rownum++) {
			for (int colnum = 0; colnum < columnCount; colnum++) {
				 LoginData[rownum-2][colnum] = excelreader.getCellData("guruCredential", colnum, rownum);
				
			}
			
		}
		
		return LoginData;
		
	}

}
