package com.InetBanking.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateCantactPage extends BasePage {
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement createContactHeader;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//i[@class='save icon']")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[@class='ui button']//i[@class='cancel icon']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstnameTxt;
	
	@FindBy(name="last_name")
	WebElement lastnameTxt;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement companyNameTxt;
	
	@FindBy(xpath = "//div[@class='visible menu transition']//div[@role='option']")
	List<WebElement> companyOptions;
	
	@FindBy(xpath="//div[@class='fields']//div[@class='four wide field']")
	WebElement accessBtn;
	
	
	
	public CreateCantactPage() {
		PageFactory.initElements(driver, this);
	}
	public String getCreateContactHeader() {
		return getHeader(createContactHeader);
	}
	public ProfilePage createContact(String fname,String lname,String cname) throws InterruptedException {
		firstnameTxt.sendKeys(fname);
		lastnameTxt.sendKeys(lname);
		companyNameTxt.sendKeys(cname);
		Thread.sleep(2000);
		if(accessBtn.getText()=="Private")
			accessBtn.click();
		saveBtn.click();
		return new ProfilePage();
	}
	

}
