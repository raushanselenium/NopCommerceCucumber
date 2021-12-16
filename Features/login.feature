Feature: Login

Scenario: Successful Login with valid credentials
	Given User launch chrome browser
	When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And user enters email as "admin@yourstore.com" and password as "admin"
	And User clicks on login
	Then Page title after login is "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page title after logout is "Your store. Login"
	And Close browser

Scenario Outline: Login Data Driven
	Given User launch chrome browser
	When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And user enters email as "<email>" and password as "<password>"
	And User clicks on login
	Then Page title after login is "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page title after logout is "Your store. Login"
	And Close browser
    Examples: 
      | email| password|	
      | admin@yourstore.com |admin|
      | admin1@yourstore.com|admin123|



