@E2E
Feature: Verify Login functionality


Background: 

Given Open the Application URL "https://www.saucedemo.com/"


@valid
Scenario: Enter valid username and password

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Take screen Shot and compare UI elements aligned correctly


@invalid
Scenario: Enter valid username and password

When Copy the "locked_out_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify "Sorry, this user has been locked out." is diplayed


@performance
Scenario: Enter performance_issue username and password

When Copy the "performance_glitch_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button

When Click on "Cart" button

When Click on "Checkout" button

And Enter "firstName"

And Enter "lastName"

And Enter "zipCode"

When Click on "Continue" button

And Click on "Finish" button

And Click on "BackHome" button


@VerifyCartPrice
Scenario: Verify Sum of Cart 

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button

When Click on "Cart" button

Then Verify all products are added in cart

When Click on "Checkout" button

And Enter "firstName"

And Enter "lastName"

And Enter "zipCode"

When Click on "Continue" button

Then Verify sum of all products is equal to total price

Then Verify sum of all products and tax is equal to total price

And Click on "Finish" button

Then Verify "Thank you for your order!" is diplayed


@RemoveCartItem
Scenario: Verify AddToCart is enabled

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button for "Sauce Labs Backpack" product

When Click on "Sauce Labs Backpack" button

And Click on "Cart" button

And Click on "CartRemove" button for "Sauce Labs Backpack"

And Click on "ContinueShoping" button

Then Verify "AddToCart" is enabled for "Sauce Labs Backpack" product


@VerifyAddToCartForAll
Scenario: Verify Cart Total price of the cart

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button

And Click on "Cart" button

When Click on "Remove" button

And Click on "ContinueShoping" button

Then Verify "AddToCart" is disabled for "all" product


@VerifyCartProduct
Scenario: Verify cart persistence after logout/login

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button

And Click on "menu" button

And Click on "Logout" button

And Copy the "standard_user" username and password

And Click on "Login" button

And Click on "Cart" button

Then Verify All products are available in the cart


@DirectCartPage
Scenario: Direct access to cart without login

When Open application Cart URL "https://www.saucedemo.com/cart.html"

Then Verify Redirect to login page and error message "Epic sadface: You can only access '/cart.html' when you are logged in." displayed


@SortFeatureA2Z
Scenario: Verify sort dropdown works (A-Z)

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

When Click on "Sort" button

And Select "Name (A to Z)" from sort dropdown

Then Verify products are sorted "Name (A to Z)" 



@SortFeatureZ2A
Scenario: Verify sort dropdown works (A-Z)

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

When Click on "Sort" button

And Select "Name (Z to A)" from sort dropdown

Then Verify products are sorted "Name (Z to A)" 


@SortFeaturePriceL2H
Scenario: Verify sort dropdown works (A-Z)

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

When Click on "Sort" button

And Select "Price (low to high)" from sort dropdown

Then Verify products are sorted "Price (low to high)" 


@SortFeaturePriceH2L
Scenario: Verify sort dropdown works (A-Z)

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

When Click on "Sort" button

And Select "Price (high to low)" from sort dropdown

Then Verify products are sorted "Price (high to low)" 


@brokenImages
Scenario: Check for broken images

When Copy the "performance_glitch_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

And Verify for Broken links



@VerifyUIElements 
Scenario: Verify all UI elements

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Check for page title, cart icon, burger menu, sorting dropdown


@VerifyUIElements 
Scenario: Verify all UI elements

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button




@VerifyNamePrice
Scenario: Verify Each card shows product name and price

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

Then Click on each product and Verify price and name displayed for each item


@VerifyCartCount
Scenario: Verify Each card shows product name and price

When Copy the "standard_user" username and password

Then Verify that correct username and password entered

When Click on "Login" button

When Click on "AddToCart" button 

Then Verify "ProductRemove" is diplayed 

Then Cart count is increased

When Click on "ProductRemove" button 

Then Verify "AddToCart" is diplayed 







