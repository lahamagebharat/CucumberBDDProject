Feature: Login

Scenario: Successful login chrome browser
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters Email "admin@yourstore.com" and Password "admin"
And click on Login
Then Page title should be "nopCommerce demo store. Login"
When User clicks on logout button
Then Page title should be "Dashboard / nopCommerce administration"
And close browser

Scenario Outline: Successful login with valid credentials DDT
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters Email "<email>" and Password "<password>"
And click on Login
Then Page title should be "nopCommerce demo store. Login"
When User clicks on logout button
Then Page title should be "Dashboard / nopCommerce administration"
And close browser
Examples:
| email                | password |
|aAdmin@yourstore.com|admin|
|aAdmin@yourstore.com|Sadmin|
|admin@yourstore.com | admin    |
