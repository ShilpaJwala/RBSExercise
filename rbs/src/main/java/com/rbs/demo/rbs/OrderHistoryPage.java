package com.rbs.demo.rbs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage {

	private WebDriver driver;
	WebDriverWait wait;
	public OrderHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		
		
	}
	
	//Locators	
	public boolean searchOrderHistory(String referencenumber) {
		
		try{
	        boolean b = driver.getPageSource().contains(referencenumber);
	        return b;
	    }
	    catch(Exception e){
	        return false;
	    }
	}
}
