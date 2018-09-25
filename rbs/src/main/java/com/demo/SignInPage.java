package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.*;

public class SignInPage {

	private WebDriver driver;
	WebDriverWait wait;
	private static final Logger LOGGER = Logger.getLogger( Class.class.getName() );

	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	//Locators
	
	//@FindBy(linkText = "T-shirts") This does not work
	@FindBy(id = "email")
	private WebElement emailTextBox;
	
	@FindBy(id = "passwd")
	private WebElement pwdTextBox;
	
	@FindBy(id = "SubmitLogin")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@title='My Store']")
	private WebElement homeButton;

	public void clickOnSignInButton(String username, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)); 
		emailTextBox.sendKeys(username);
		pwdTextBox.sendKeys(password);
		submitButton.click();
		
		LOGGER.log(Level.INFO, "User successfully signed-in");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("my-account"))); 
		homeButton.click();
		
	}	
}
