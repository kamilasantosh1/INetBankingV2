package com.InetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.AddNewCustomerPage;
import com.InetBanking.pageObjects.LoginPage;

import generic.BaseTest;

public class TC_CreateCustomer_001 extends BaseTest{
	
	@Test()
	public void createCustomerTest() throws InterruptedException {
		LoginPage loginObj = new LoginPage(driver);
		String username = excelreader.getCellData("guruCredential", "Username", 2);
		loginObj.setUserName(username);
		logger.info("username entered");
		String password = excelreader.getCellData("guruCredential", "password", 2);
		loginObj.setPassword(password);
		logger.info("password entered");
		loginObj.clickSubmit();
		logger.info("submit button clicked");
		
		Thread.sleep(3000);
	
		AddNewCustomerPage newcustomerObj = new AddNewCustomerPage(driver);
		newcustomerObj.clickNewCustomerLink();
		logger.info("new Customer link clicked");
		
		String customername = excelreaderCustDetails.getCellData("CustmDetails", "NAME", 2);
		newcustomerObj.setCustomerName(customername);
		logger.info("Customer name entered");
		
		String gender = excelreaderCustDetails.getCellData("CustmDetails", "GENDER", 2);
		newcustomerObj.setGender(gender);
		logger.info("Customer gender selected");
		
		String dd = excelreaderCustDetails.getCellData("CustmDetails", "DOBDAY", 2);
		String mm = excelreaderCustDetails.getCellData("CustmDetails", "DOBMONTH", 2);
		String yy = excelreaderCustDetails.getCellData("CustmDetails", "DOBYEAR", 2);
		//System.out.println(dd+mm+yy);
		newcustomerObj.setDOB("10","05","1995");
		logger.info("DOB entered");
		
		String address = excelreaderCustDetails.getCellData("CustmDetails", "ADDRESS", 2);
		newcustomerObj.setAddress(address);
		logger.info("address entered");
		
		String city = excelreaderCustDetails.getCellData("CustmDetails", "CITY", 2);
		newcustomerObj.setCity(city);
		logger.info("city name entered");
		
		String state = excelreaderCustDetails.getCellData("CustmDetails", "STATE", 2);
		newcustomerObj.setState(state);
		logger.info("state name entered");
		
		String pin = excelreaderCustDetails.getCellData("CustmDetails", "PIN", 2);
		newcustomerObj.setPinCode(pin);
		logger.info("pin entered");
		
		String mobileNum = excelreaderCustDetails.getCellData("CustmDetails", "MOBILE", 2);
		//System.out.println(mobileNum);
		//newcustomerObj.setPhoneNumber(mobileNum);
		newcustomerObj.setPhoneNumber("8754587624");
		logger.info("mobile number entered");
		
		//String email = excelreaderCustDetails.getCellData("CustmDetails", "EMAIL", 2);
		newcustomerObj.setEmail(randomString()+"@gmail.com");
		logger.info("email entered");
		
		String cusPassword = excelreaderCustDetails.getCellData("CustmDetails", "PASSWORD", 2);
		newcustomerObj.setPassword(cusPassword);
		logger.info("password entered");
		
		newcustomerObj.clickSubmit();
		logger.info("submit button clicked");
		
		Thread.sleep(3000);
		boolean successMsg = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (successMsg==true) {
			logger.info("Test pass");
			Assert.assertTrue(true);
			
		} else {
			
			String alertText = driver.switchTo().alert().getText();
			logger.info("test failed because "+alertText);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			

		}
		
		
		
		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@DataProvider(name="customerdetails")
	String [][] getData(){
		int rowCount = excelreaderCustDetails.getRowCount("CustmDetails");
		int columnCount = excelreaderCustDetails.getColumnCount("CustmDetails");
		
		String [][] custmDetails = new String [rowCount][columnCount];
		for (int rownum = 2; rownum < rowCount; rownum++) {
			for (int colnum = 0; colnum < columnCount; colnum++) {
				
			 custmDetails[rownum-2][colnum] = excelreaderCustDetails.getCellData("CustmDetails", colnum, rownum);
				
			}
			
		}
		return custmDetails;
		
	}*/


