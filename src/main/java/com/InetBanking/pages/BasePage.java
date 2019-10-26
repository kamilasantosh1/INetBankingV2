package com.InetBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic.BaseTest;

public class BasePage extends BaseTest {
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	public String getHeader(WebElement element) {
		return element.getText();
	}

}
