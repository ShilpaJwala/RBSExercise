package com.rbs.demo.rbs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtProduct {
	private WebDriver driver;
	WebDriverWait wait;
	
	public TshirtProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		//wait for the t-shirt category page to load
		wait = new WebDriverWait(driver, 20);
			
	}
	
	//Locators
	
	//@FindBy(linkText = "T-shirts") This does not work
	@FindBy(id = "add_to_cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//*[@title='Proceed to checkout']")
	private WebElement proceedButton;

	public void clickOnAddToCart() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
		proceedButton.click();
		
	}

}
