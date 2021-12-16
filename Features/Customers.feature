Feature: Customers

Background: Common steps are executed first 
Given User launch chrome browser
When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters email as "admin@yourstore.com" and password as "admin"
And User clicks on login
Then User can view Dashboard
When User clicks on Customers menu
And User clicks on customers menu item

@AddCustomer
Scenario: Add a new Customer
And User clicks on Add new button
Then User can see Add a new Customer page
When User enters customer info
And User clicks on Save button
Then User can view confirmation message "The new customer has been added successfully"
And Close browser

@SearchCustomers
Scenario: Search customer by Email id
When User enters Customer email
And User clicks on search button
Then User should find email results in the Search table
And Close browser







