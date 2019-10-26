package com.InetBanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactPageHeader;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactBtn;

	public  ContactPage() {
		PageFactory.initElements(driver, this);
	}
	public String getConatctPageHeader() {
		return getHeader(contactPageHeader);
	}
	public CreateCantactPage clickNewContactBtn() {
		newContactBtn.click();
		return new CreateCantactPage();
	}
}
