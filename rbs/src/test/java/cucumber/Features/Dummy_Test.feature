Feature: RBS Dummy Test

@Test1 @TestAll
Scenario: Order T-Shirt and Verify in Order History
	Given user "someone@example.com" is on Home Page
	When the user orders a "Faded Short Sleeve T-shirts"
	Then the order is placed successfully
	
@Test2 @TestAll
Scenario: Update user personal information
	Given user "someone@example.com" is on Home Page
	When the user updates "Firstname" to "QA" in personal information
	Then personal information gets updated successfully
	



	