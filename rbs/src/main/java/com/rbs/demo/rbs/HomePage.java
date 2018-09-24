package com.rbs.demo.rbs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		
		
	}
	
	//Locators
	
	//@FindBy(linkText = "T-shirts") This does not work
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement tshirtLink;
	
	@FindBy(xpath = "//*[@title='Log in to your customer account']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//*[@title='Log me out']")
	private WebElement signOutButton;
	
	@FindBy(xpath = "//*[@title='View my customer account']")
	private WebElement userAccountLink;
	
	
	//This function takes category as an argument. This could be T-shirt, dress or Women
	public void clickOnLink(String cat) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header_logo"))); 
		if(cat.equals("T-shirts")) {
			tshirtLink.click();
		}
	}

	//Function to log in to the website
	public void clickOnSignIn() {
		signInButton.click();
	}

	//Function to log out of the website
	public void clickOnSignOut() {
		signOutButton.click();		
	}

	//Function to click on User's account
	public void clickOnUserAccount() {
		userAccountLink.click();
		
	}
}
