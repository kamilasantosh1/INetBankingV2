package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')] ")
	WebElement newCustomerLnk;
	
	@FindBy(name="name")
	WebElement custmName;
	
	@FindBy(name="rad1")
	WebElement radGender;
	
	@FindBy(id="dob")
	WebElement dobTBX;
	
	@FindBy(name="addr")
	WebElement addressTBX;
	
	@FindBy(name="city")
	WebElement cityTBX;
	
	@FindBy(name="state")
	WebElement stateTBX;
	
	@FindBy(name="pinno")
	WebElement pinCodeTBX;
	
	@FindBy(name="telephoneno")
	WebElement phonenoTBX;
	
	@FindBy(name="emailid")
	WebElement emailIdTBX;
	
	@FindBy(name="password")
	WebElement passwordTBX;
	
	@FindBy(name="sub")
	WebElement submitBTN;
	
	public AddNewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewCustomerLink() {
		newCustomerLnk.click();
	}
	
	public void setCustomerName(String customername) {
		custmName.sendKeys(customername);
	}
	
	public void setGender(String gendername) {
		radGender.sendKeys(gendername);
	}
	public void setDOB(String dd,String mm,String yy) {
		dobTBX.clear();
		dobTBX.sendKeys(dd);
		dobTBX.sendKeys(mm);
		dobTBX.sendKeys(yy);
		
	}
	public void setAddress(String address) {
		addressTBX.sendKeys(address);
	}
	
	public void setCity(String city) {
		cityTBX.sendKeys(city);
	}
	
	public void setState(String state) {
		stateTBX.sendKeys(state);
	}
	public void setPinCode(String pin) {
		pinCodeTBX.sendKeys(String.valueOf(pin));
	}
	public void setPhoneNumber(String phNum) {
		phonenoTBX.clear();
		phonenoTBX.sendKeys(phNum);
	}
	public void setEmail(String email) {
		emailIdTBX.sendKeys(email);
	}
	public void setPassword(String password) {
		passwordTBX.sendKeys(password);
	}
	public void clickSubmit() {
		submitBTN.click();
	}
}
