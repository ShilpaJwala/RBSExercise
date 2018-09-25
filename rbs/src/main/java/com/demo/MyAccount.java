package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount {

	private WebDriver driver;
	WebDriverWait wait;

	public MyAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	//Locators
	@FindBy(xpath = "//*[@title='Information']")
	private WebElement personalInfoLink;
	
	@FindBy(name = "submitIdentity")
	private WebElement saveButton;
	
	@FindBy(id = "firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "old_passwd")
	private WebElement oldPasswdTextBox;
	
	@FindBy(id = "passwd")
	private WebElement passwd;
	
	@FindBy(id = "confirmation")
	private WebElement passwdConfirmation;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement feedbackTextBox;
	
	
	
	//Function to click on User's personal information link
	public void clickOnPersonalInfo() {
		wait.until(ExpectedConditions.elementToBeClickable(personalInfoLink)); 
		personalInfoLink.click();		
	}
	
	//Function to save personal information
	public void savePersonalInfo() {
		saveButton.click();		
	}
	
	//Function to key-in firstname
	public void updateInfo(String textBoxField, String textBoxValue) {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));	
		if (textBoxField.equals("Firstname")) {
			firstNameTextBox.clear();
			firstNameTextBox.sendKeys(textBoxValue);
		}
	}

	public void updatePassword(String password) {
		oldPasswdTextBox.sendKeys(password);
		passwd.sendKeys(password);
		passwdConfirmation.sendKeys(password);
		
	}

	public void clickOnSaveButton() {
		saveButton.click();
		
	}

	public String getFeedbackMessage() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='alert alert-success']")));
		String feedback = feedbackTextBox.getText();
		return feedback;
		
	}
	
	
	
}
