package com.InetBanking.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
public static String url;
	@FindBy(xpath="//div[contains(text(),'Deals Summary')]")
	WebElement header;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companyLink;
	
	@FindBy(xpath="//div[@id='main-nav']//a")
	List<WebElement> allmoduleLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String getHeader() {
		return getHeader(header);
	}
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public ComapnyPage clickCompanyLink() {
		companyLink.click();
		return new ComapnyPage();
	}
	public ContactPage clickContactLink() {
		contactLink.click();
		return new ContactPage();
	}
	public void checkAllModuleLinks() {
		int links = allmoduleLink.size();
		for (WebElement link : allmoduleLink) {
			 url = link.getAttribute("href");
			logger.info(url);
			System.out.println(url);
			try {
				URL con = new URL(url);
				HttpsURLConnection httpcon = (HttpsURLConnection)con.openConnection();
				httpcon.setConnectTimeout(2000);
				httpcon.connect();
				if (httpcon.getResponseCode()==200) {
					logger.info(url+" - "+httpcon.getResponseMessage());
					
				} else if(httpcon.getResponseCode()==404){
					logger.info(url+" - "+httpcon.getResponseMessage());

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
