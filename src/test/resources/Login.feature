@E2E
Feature: Verify Login functionality


Background: 

Given Open the Application URL "https://www.saucedemo.com/"


@valid
Scenario: Enter valid username and password

When Copy the "standard_user" username and password

Then Verify that correct username and password and entered

When Click on "Login" button

Then Verify user is navigated to products page



@invalid
Scenario: Enter valid username and password

When Copy the "locked_out_user" username and password

Then Verify that correct username and password and entered

When Click on "Login" button

Then Verify "Sorry, this user has been locked out." is diplayed


@problemUser
Scenario: Enter problemUser username and password

When Copy the "problem_user" username and password

Then Verify that correct username and password and entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button for "Sauce Labs Fleece Jacket" product

Then Verify "AddToCart" is enabled for "Sauce Labs Fleece Jacket" product




@performance
Scenario: Enter performance_issue username and password

When Copy the "performance_glitch_user" username and password

Then Verify that correct username and password and entered

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
Scenario: Verify Cart Total price of the cart

When Copy the "standard_user" username and password

Then Verify that correct username and password and entered

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

And Click on "Finish" button

Then Verify "Thank you for your order!" is diplayed


@VerifyProductsPage
Scenario: Verify Cart Total price of the cart

When Copy the "standard_user" username and password

Then Verify that correct username and password and entered

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

Then Verify that correct username and password and entered

When Click on "Login" button

Then Verify user is navigated to products page

When Click on "AddToCart" button

And Click on "Cart" button

When Click on "Remove" button

And Click on "ContinueShoping" button

Then Verify "AddToCart" is disabled for "all" product



