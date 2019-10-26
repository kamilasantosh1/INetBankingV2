package com.InetBanking.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.InetBanking.pages.HomePage;
import com.InetBanking.pages.LoginPage;

import generic.BaseTest;
import generic.lib;

public class HomePageTest extends BaseTest {

	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	public void setup() {
		initilization();
		logger.info("browser open");
		wait = new WebDriverWait(driver, 10);
		login = new LoginPage();
	    home = login.doLogin(lib.getPropertyValue("USERNAMECRM"),lib.getPropertyValue("PASSWORDCRM"));
	    logger.info("login done");
		
	}
	@Test(priority=1)
	public void checkHeader() {
		String header = home.getHeader();
		Assert.assertEquals(header, "Deals Summary");
	}
	@Test(priority=2)
	public void checkModuleLinks() {
		home.checkAllModuleLinks();
		Assert.assertEquals("ok","ok");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
