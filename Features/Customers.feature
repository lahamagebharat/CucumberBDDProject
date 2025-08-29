Feature:CustomersScenario: Add new customer

Background:

Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters Email "admin@yourstore.com" and Password "admin"
And click on Login
Then User can view dashboard

@Sanity @regression
Scenario: Add new customer
When User clicks on Customers menu
And User clicks on Customers menu item
And User clicks on Add new button
Then User can view customers page
Then User can view add new customer page
When User enters customer information
And User clicks on save button
Then User can view customer information "Customer"
And close browser

@regression
Scenario: Search customer by email
When User clicks on Customers menu
And User clicks on Customers menu item
And User enters email
And User clicks on search button
Then User should found email in the search table
And close browser

Scenario: Search customer by name
When User clicks on Customers menu
And Enter customer name
And User enters last name
And User clicks on search button
Then User should found name in the search table
And close browser

