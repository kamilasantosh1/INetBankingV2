package com.InetBanking.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComapnyPage extends BasePage {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement companyPageHeader;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newLink;
	
	@FindBy(xpath="//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr/td[2]")
	List<WebElement> companies;
	
public ComapnyPage() {
	PageFactory.initElements(driver, this);
}
public String getCompanyPageHeader() {
	return getHeader(companyPageHeader);
}
public List<String> getComapnyNameList() {
	int companyNumber = companies.size();
	List<String> name = new ArrayList<String>();
	for (WebElement company : companies) {
		String companyName = company.getText();
		name.add(companyName);
		}
	return name;
}
}
