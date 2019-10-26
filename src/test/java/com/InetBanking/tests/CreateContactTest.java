package com.InetBanking.tests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.InetBanking.pages.ContactPage;
import com.InetBanking.pages.CreateCantactPage;
import com.InetBanking.pages.HomePage;
import com.InetBanking.pages.LoginPage;
import com.InetBanking.pages.ProfilePage;

import generic.BaseTest;
import generic.lib;

public class CreateContactTest extends BaseTest{
HomePage home;
ContactPage contact;
CreateCantactPage createCantact;
ProfilePage profile;
public String firstName ="Santosh";
public String lastName="Kamila";
public String comp = "foiwe";

	@BeforeMethod
	public void setup() {
		initilization();
		logger.info("browser open");
		wait = new WebDriverWait(driver, 10);
		LoginPage login = new LoginPage();
	    home = login.doLogin(lib.getPropertyValue("USERNAMECRM"), lib.getPropertyValue("PASSWORDCRM"));
	    logger.info("login done");

	}
	@Test(priority=1)
	public void checkContactPageHeader() {
		contact = home.clickContactLink();
		logger.info("contact module clicked");
		String header = contact.getConatctPageHeader();
		Assert.assertEquals("Contacts", header);
		logger.info("header matched");
		
	}
	@Test(priority=2)
	public void checkCreateContactPageHeader() {
		contact = home.clickContactLink();
		logger.info("contact module clicked");
		createCantact = contact.clickNewContactBtn();
		logger.info("create new cantact botton clicked");
		String header = createCantact.getCreateContactHeader();
		Assert.assertEquals("Create New Contact", header);
		logger.info("header matched");
	}
	@Test(priority=3)
	public void createContact() throws InterruptedException {
		contact = home.clickContactLink();
		logger.info("contact module clicked");
		createCantact = contact.clickNewContactBtn();
		logger.info("create new cantact botton clicked");
		profile = createCantact.createContact(firstName, lastName, comp);
		Thread.sleep(2000);
		String profileName = profile.getProfileName();
		Assert.assertEquals("Santosh Kamila", profileName);
		logger.info("contact created successfully");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
