package com.InetBanking.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.InetBanking.pages.HomePage;
import com.InetBanking.pages.LoginPage;

import generic.BaseTest;
import generic.lib;

public class LoginTest extends BaseTest {
	public LoginTest() {
		super();
	}

	LoginPage login;
	HomePage home;
	
@BeforeMethod
public void setUp() {
	initilization();
	logger.info("initialization of brower");
	login = new LoginPage();
	wait = new WebDriverWait(driver,10);
	
}
@Test(priority=1)
public void loginPageTitleTest() {
	String title = login.getLoginPageTitle();
	logger.info(title+" :  login page  title ");
	System.out.println(title);
}
@Test(priority=2)
public void loginTest() {
	String username = lib.getPropertyValue("USERNAMECRM");
	String password = lib.getPropertyValue("PASSWORDCRM");
	 home = login.doLogin(username, password);
	 logger.info("login completed");
	 String header = home.getHeader();
	 String title = home.getTitle();
	 wait.until(ExpectedConditions.titleContains(title));
	 logger.info("header found");
	 Assert.assertEquals(header, "Deals Summary");
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
}
