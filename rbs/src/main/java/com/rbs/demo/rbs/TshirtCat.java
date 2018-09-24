package com.rbs.demo.rbs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtCat {

	
	private WebDriver driver;
	WebDriverWait wait;

	public TshirtCat(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		//wait for the t-shirt category page to load
		wait = new WebDriverWait(driver, 10);
				
	}
	
	//Locators
	
	//@FindBy(linkText = "T-shirts") This does not work
	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	private WebElement tshirtLink;

	public void clickOnTshirt(String tshirt) {
		wait.until(ExpectedConditions.attributeContains(tshirtLink, "title", tshirt));
		if(tshirt.equals("Faded Short Sleeve T-shirts")) {
			tshirtLink.click();
		}	
	}
}
