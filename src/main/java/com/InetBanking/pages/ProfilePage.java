package com.InetBanking.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage{
	@FindAll(@FindBy(xpath="//div[@class='ui header item mb5 light-black']"))
	List<WebElement> userProfileHeader;
	
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	public String getProfileName() {
		WebElement profileHeader = null;
		for (int i = 0; i < userProfileHeader.size(); i++) {
		profileHeader = userProfileHeader.get(i);
		System.out.println(profileHeader.getText());
			
		}
		return getHeader(profileHeader);
	}

}
