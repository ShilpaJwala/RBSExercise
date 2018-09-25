package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage {

	private WebDriver driver;
	WebDriverWait wait;
	public CartSummaryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		
	}
	
	//Locators
	
	//@FindBy(xpath = "//*[@title='Proceed to checkout']")
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	private WebElement proceedToCheckOutlink;
	
	
	@FindBy(name = "processAddress")
	private WebElement processAddress;
	
	@FindBy(name = "processCarrier")
	private WebElement processCarrier;
	
	@FindBy(id = "cgv")
	private WebElement processCarrierCheckBox;
	
	@FindBy(xpath = "//span[contains(text(), 'I confirm my order')]" )
	private WebElement confirmOrderButton;
	
	
	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	private WebElement selectWirePayment;
	
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/div")
	private WebElement referenceNumberText;
	
	
	@FindBy(xpath = "//*[@title='Back to orders']")
	private WebElement backToOrdersLink;
	
	
	public void clickOnProceedSummary() {
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutlink)); 
		proceedToCheckOutlink.click();		
	}
	
	public void clickOnProceedAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(processAddress)); 
		processAddress.click();		
	}
	
	public void clickOnProceedShipping() {
		wait.until(ExpectedConditions.elementToBeClickable(processCarrier)); 
		processCarrierCheckBox.click();
		processCarrier.click();		
	}
	
	public void selectWirePaymentType() {
		wait.until(ExpectedConditions.elementToBeClickable(selectWirePayment));
		selectWirePayment.click();
		
	}
	
	public void clickOncConfirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
		confirmOrderButton.click();
		
	}

	public String getReferenceNumber() {
		return referenceNumberText.getText();
	}
	
	public void clickOnBackToOrders() {
		backToOrdersLink.click();
	}
	
}
