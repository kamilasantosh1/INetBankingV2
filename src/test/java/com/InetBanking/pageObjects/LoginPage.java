package com.InetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement usernameTB;
	
	@FindBy(name="password")
	WebElement passwordTB;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath=("//a[@text='Log out']"))
	WebElement  logoutBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String uname) {
		usernameTB.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		passwordTB.sendKeys(pwd);
	}
	public void clickSubmit() {
		loginBtn.click();
	}
	public void clickLogoutBtn() {
		logoutBtn.click();
	}

}
