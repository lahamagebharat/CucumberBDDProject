Feature: Login



Scenario: Successful login chrome browser
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters Email "admin@yourstore.com" and Password "admin"
And click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on logout button
Then Page title should be "nopCommerce demo store. Login"
And close browser