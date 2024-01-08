@swaglabs
Feature: Automation of SwagLabs Website

@open_url 
Scenario: open the swaglabs site
Given user has opened browser
Then validate home page  

@invalid_login 
Scenario Outline: Login functionality for a swaglabs site
When user enter invalid username as "<username>" and password as "<password>"
Then login should be unsuccessful
Examples:
 |username|password|
 |Groot|Groot@123|
 
@valid_login
Scenario Outline: Login functionality for a swaglabs site
When user enter valid username as "<username1>" and password as "<password1>"
Then login should be successful
Examples:
 |username1|password1|
 |standard_user|secret_sauce|

@categories 
Scenario: Verifying product list
Given user is on product page
Then read the product list

@details
Scenario: Verifying product list
When user clicks on any product
Then read the product details

@add_to_cart 
Scenario: validating add to cart button
When clicks on add to cart button 
Then product is added to cart

@delete_product 
Scenario: validating delete product functionality
Given user is on the cart page
When user clicks on delete 
Then product is removed from the cart

@purchase_form 
Scenario: validating place order
Given user is on the cart page
When clicks on checkout button,enters required details & clicks on Finish button
Then confirmation details are displayed 
