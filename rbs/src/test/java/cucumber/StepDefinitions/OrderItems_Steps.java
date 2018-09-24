package cucumber.StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.rbs.demo.rbs.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import java.util.logging.*;

public class OrderItems_Steps {

	private static String password;
	public static WebDriver driver;
	String referencenumberText;
	String reference = null;
	String actResult;
	private static final Logger LOGGER = Logger.getLogger( Class.class.getName() );
	
	@Before
	public static void setUp() throws IOException {
		LOGGER.log(Level.INFO, "Setting Up Test");
		password = Utils.getProp("password");
			
		String path = Utils.getProp("userDir");
		String chromePath = Utils.getProp("chromePath");
		
		System.setProperty("webdriver.chrome.driver",path+chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	
	}
	
	@After
	public static void tearDown() {
	
		LOGGER.log(Level.INFO, "Tearing down Test");
		HomePage hp = new HomePage(driver);
		hp.clickOnSignOut();	
		LOGGER.log(Level.INFO, "Logging user out");
			
		//driver.quit();
		LOGGER.log(Level.INFO, "Closing the browser");
		
		 if (driver == null) {
		        return;
		    }
		    driver.quit();
		    driver = null;
	}
	
	@Given("^user \"([^\"]*)\" is on Home Page$")
	public void user_is_on_Home_Page(String username) throws Throwable {
	
		LOGGER.log(Level.INFO, "User is logging into the website");
		HomePage hp = new HomePage(driver);
		hp.clickOnSignIn();
		
		LOGGER.log(Level.INFO, "User is keying the login details");
		SignInPage sip = new SignInPage(driver);
		sip.clickOnSignInButton(username,password);
		
	}


	@When("^the user orders a \"([^\"]*)\"$")
	public void the_user_orders_a(String tshirtname) throws Throwable {
		
		LOGGER.log(Level.INFO, "User selects T-shirts category");
		HomePage hp = new HomePage(driver);
		hp.clickOnLink("T-shirts");
		
		LOGGER.log(Level.INFO, "User selects ",tshirtname);
		TshirtCat tc = new TshirtCat(driver);
		tc.clickOnTshirt(tshirtname);
		
		LOGGER.log(Level.INFO, "User adds the T-shirt into basket");
		TshirtProduct tp = new TshirtProduct(driver);
		tp.clickOnAddToCart();
		
		LOGGER.log(Level.INFO, "User proceeds through the checkout and confirms order");
		CartSummaryPage csp = new CartSummaryPage(driver);
		csp.clickOnProceedSummary();
		csp.clickOnProceedAddress();
		csp.clickOnProceedShipping();
		csp.selectWirePaymentType();
		csp.clickOncConfirmOrder();
		
		referencenumberText = csp.getReferenceNumber();
		// Extract Order reference number by matching the following pattern
		Pattern p = Pattern.compile("\\b[A-Z]{9,}\\b");
		Matcher m = p.matcher(referencenumberText);
		while (m.find()) {
		    reference = m.group();
		    LOGGER.log(Level.INFO, "Order reference Number placed: " + reference);
		}

		csp.clickOnBackToOrders();
		
	}

	@Then("^the order is placed successfully$")
	public void the_order_is_placed_successfully() throws Throwable {
		
		OrderHistoryPage ohp = new OrderHistoryPage(driver);
		//ohp.searchOrderHistory(reference);
		Boolean res = ohp.searchOrderHistory(reference);
		LOGGER.log(Level.INFO, "Order reference fund in Order history: " + res);
		try {
			assertTrue(res);
			LOGGER.log(Level.INFO, "There was a match!");
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There was no match in Order history");
			e.printStackTrace();
		}
		
	}
	
	@When("^the user updates \"([^\"]*)\" to \"([^\"]*)\" in personal information$")
	public void the_user_updates_to_in_personal_information(String arg1, String arg2) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clickOnUserAccount();
	    
		MyAccount ma = new MyAccount(driver);
		ma.clickOnPersonalInfo();
		ma.updateInfo(arg1,arg2);
		ma.updatePassword(password);
		
		LOGGER.log(Level.INFO, "Updating " +arg2);
		ma.clickOnSaveButton();
		LOGGER.log(Level.INFO, "click on Save button");
		actResult= ma.getFeedbackMessage();
	}

	@Then("^personal information gets updated successfully$")
	public void personal_information_gets_updated_successfully() throws Throwable {
		
		
		String expResult="Your personal information has been successfully updated.";
		LOGGER.log(Level.INFO, "Actual Result = "+actResult);
		LOGGER.log(Level.INFO, "Expected Result = "+expResult);
		assertEquals("Update failed",expResult, actResult);
		
		
		    
	}
	
}
