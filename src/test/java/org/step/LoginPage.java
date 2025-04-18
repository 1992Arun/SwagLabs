package org.step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BaseClass {

	public static long startTime;

	@Given("Open the Application URL {string}")
	public void open_the_Application_URL(String string) {

		launchURL(string);

	}

	@When("Copy the {string} username and password")
	public void copy_the_username_and_password(String string) {

		if (string.equalsIgnoreCase("standard_user")) {

			userName = l.getUser_Name(1);

			password = l.getPasswordText();

			sendKeys(l.getUserName(), userName);

			sendKeys(l.getPassword(), password);

		} else if (string.equalsIgnoreCase("locked_out_user")) {

			userName = l.getUser_Name(2);

			password = l.getPasswordText();

			sendKeys(l.getUserName(), userName);

			sendKeys(l.getPassword(), password);

		} else if (string.equalsIgnoreCase("problem_user")) {

			userName = l.getUser_Name(3);

			password = l.getPasswordText();

			sendKeys(l.getUserName(), userName);

			sendKeys(l.getPassword(), password);
		}

		else if (string.equalsIgnoreCase("performance_glitch_user")) {

			userName = l.getUser_Name(4);

			password = l.getPasswordText();

			sendKeys(l.getUserName(), userName);

			sendKeys(l.getPassword(), password);
		}

	}

	@Then("Verify that correct username and password and entered")
	public void verify_that_correct_username_and_password_and_entered() {

		Assert.assertTrue(getAttribute(l.getUserName(), "value").equals(userName));

		Assert.assertTrue(getAttribute(l.getPassword(), "value").equals(password));

	}

	@When("Click on {string} button")
	public void click_on_button(String string) {

		if (string.equalsIgnoreCase("Login")) {

			click(l.getLoginButton());

		} else if (string.equalsIgnoreCase("AddToCart")) {

			List<WebElement> addToCartButton = p.getAddToCartButton();

			List<WebElement> listOfProducts = p.getListOfProducts();

			List<WebElement> listOfProductsprice = p.getListOfProductsprice();

			numberOfProducts =6;

			for (int i = numberOfProducts-1; i >= 0; i--) {

				//click(addToCartButton.get(i));


				click(p.productAddToCart(getText(listOfProducts.get(i))));

				productname.add(getText(listOfProducts.get(i)));

				productPrice.add(Double.valueOf(getText(listOfProductsprice.get(i)).substring(1)));



			}

		}

		else if (string.equalsIgnoreCase("Remove")) {

			List<WebElement> listOfCartProducts = p.getListOfCartProducts();


			for (int i = listOfCartProducts.size() - 1; i >= 0; i--) {

				//				listOfCartProducts = p.getListOfCartProducts();



				click(p.productRemove(getText(listOfCartProducts.get(i))));

			}


		}

		else if (string.equalsIgnoreCase("Cart")) {

			sleep(4);

			click(webDriverWait(5, p.getCartButton()));

		}

		else if (string.equalsIgnoreCase("Checkout")) {

			click(webDriverWait(5, checkout.getCheckOutButton()));
		}

		else if (string.equalsIgnoreCase("Continue")) {

			click(checkout.getContinueButton());
		}

		else if (string.equalsIgnoreCase("Finish")) {

			click(checkout.getFinishButton());
		}

		else if (string.equalsIgnoreCase("BackHome")) {

			click(checkout.getBackHomeButton());

		}

		else if (string.equalsIgnoreCase("Remove from Cart")) {

			click(p.getRemoveButtonInCart());

		} 

		else if (string.equalsIgnoreCase("Back to Products")) {

			click(checkout.getBackHomeButton());

		}

		else if (string.equalsIgnoreCase("Sauce Labs Backpack")) {

			click(p.product(string));

		}

		else if (string.equalsIgnoreCase("ContinueShoping")) {

			click(p.getContinueShoping());

		}


		else if (string.equalsIgnoreCase("menu")) {

			click(l.getMenuButton());

		}

		else if (string.equalsIgnoreCase("Logout")) {

			click(l.getLogoutButton());

		}

		else if (string.equalsIgnoreCase("Sort")) {

			click(l.getSortButton());

		}

	}

	@Then("Verify all products are added in cart")
	public void verify_all_products_are_added_in_cart() {

		List<WebElement> cartProducts = checkout.getCartProducts();

		List<WebElement> cartProductsPrice = checkout.getCartProductsPrice();

		for (int i = 0; i < productname.size(); i++) {

			Assert.assertTrue(getText(cartProducts.get(i)).contains(productname.get(i)));

			Assert.assertTrue(Double.valueOf(getText(cartProductsPrice.get(i)).substring(1))==productPrice.get(i));

			String text = getText(cartProductsPrice.get(i));

			String split = text.substring(1);

		}

	}

	@Then("Verify user is navigated to products page")
	public void verify_user_is_navigated_to_products_page() {

		Assert.assertTrue(p.getProductsText().isDisplayed());

	}

	@Then("Verify {string} is diplayed")
	public void verify_is_diplayed(String string) {

		if (string.equalsIgnoreCase("Remove")) {

			Assert.assertTrue(p.getAddToCartRemoveButton().isEnabled());

		}

		else if (string.equalsIgnoreCase("AddToCart")) {

			try {

				Assert.assertTrue(p.getAddToCartButton().get(0).isEnabled());

			} catch (Exception a) {

				Assert.assertTrue(false);

			}

		} else if (string.equalsIgnoreCase("Thank you for your order!")) {

			Assert.assertEquals(string, getText(checkout.getOrderPlacedSuccessMessage()));

		}

		else if (string.equalsIgnoreCase("CartButtonProducts number")) {


			String text = getText(l.getNumberOfProductsInCart());

			Integer valueOf = Integer.valueOf(text);

			System.out.println(getText(l.getNumberOfProductsInCart()));

			Assert.assertTrue(valueOf==numberOfProducts);



		}  else if (string.equalsIgnoreCase("Remove from Cart")) {

			Assert.assertTrue(p.getRemoveButtonInCart().isDisplayed());

		}



	}

	@When("Enter {string}")
	public void enter(String string) {

		if (string.equalsIgnoreCase("firstName")) {

			sendKeys(checkout.getFirstName(), "Arun");

		} else if (string.equalsIgnoreCase("lastName")) {

			sendKeys(checkout.getLastName(), "kumar");

		} else if (string.equalsIgnoreCase("zipCode"))

			sendKeys(checkout.getZipCode(), "623082");

	}

	@Then("Verify sum of all products is equal to total price")
	public void verify_sum_of_all_products_is_equal_to_total_price() {

		String[] split = getText(checkout.getItemTotalPrice()).split(" ");

		split[2].substring(1);

		Double sum = Double.valueOf(split[2].substring(1));

		Double temp = 0.00;

		for (int i = 0; i < productPrice.size(); i++) {

			temp = temp + Double.valueOf(productPrice.get(i));

		}

		sleep(4);

		Assert.assertEquals(sum, temp, 0.01);

		System.out.println(sum);

		System.out.println(temp);

	}

	@When("Click on {string} button for {string} product")
	public void click_on_button_for_product(String string, String string2) {

		try {

			if (string.equalsIgnoreCase("AddToCart")) {


				click(p.productAddToCart(string2));

			}

		}catch(Exception e ) {

			System.out.println("Button is not displayed");

		}

	}


	@When("Click on {string} button for {string}")
	public void click_on_button_for(String string, String string2) {

		if(string.equalsIgnoreCase("CartRemove")) {

			click(p.productRemove(string2));

		}

	}

	@Then("Verify {string} is disabled for {string} product")
	public void verify_is_disabled_for_product(String string, String string2) {

		if(string2.equalsIgnoreCase("Sauce Labs Fleece Jacket")) {

			try {

				Assert.assertTrue(!p.productAddToCart(string2).isEnabled());

			} catch(Exception e) {

				Assert.assertTrue(false);

			}

		}

	}


	@Then("Verify {string} is enabled for {string} product")
	public void verify_is_enabled_for_product(String string, String string2) {

		if(string.equalsIgnoreCase("AddToCart")) {

			try {

				Assert.assertTrue(p.productAddToCart(string2).isEnabled());

			} catch(Exception e) {

				Assert.assertTrue(false);

			}



		}


		else if(string.equalsIgnoreCase("AddToCart")) {

			try {

				Assert.assertTrue(p.productAddToCart(string2).isEnabled());

			} catch(Exception e) {

				Assert.assertTrue(false);

			}



		}


	}


	@Then("Verify sum of all products and tax is equal to total price")
	public void verify_sum_of_all_products_and_tax_is_equal_to_total_price() {

		String[] split2 = getText(checkout.getTotalWithTax()).split(" ");

		split2[1].substring(1);

		System.out.println(split2[1].substring(1));

		Double total = Double.valueOf(split2[1].substring(1));

		String[] split = getText(checkout.getTax()).split(" ");

		String tax1 =split[1].substring(1);

		Double tax = Double.valueOf(tax1);

		System.out.println("Tax :"+tax);

		String[] split1 = getText(checkout.getItemTotalPrice()).split(" ");

		split1[2].substring(1);

		Double sum = Double.valueOf(split1[2].substring(1));

		Double temp = 0.00;

		for (int i = 0; i < productPrice.size(); i++) {

			temp = temp + Double.valueOf(productPrice.get(i));

		}

		Assert.assertEquals(sum, temp, 0.01);

		System.out.println("total: "+ total);

		Assert.assertEquals(total, temp+tax, 0.01);

	}

	@Then("Verify All products are available in the cart")
	public void verify_All_products_are_available_in_the_cart() {

		List<WebElement> cartProducts = checkout.getCartProducts();

		List<WebElement> cartProductsPrice = checkout.getCartProductsPrice();

		for (int i = 0; i < productname.size(); i++) {

			Assert.assertTrue(getText(cartProducts.get(i)).contains(productname.get(i)));

			Assert.assertTrue(Double.valueOf(getText(cartProductsPrice.get(i)).substring(1))==productPrice.get(i));

			String text = getText(cartProductsPrice.get(i));

			String split = text.substring(1);

		}


	}


	@When("Open application Cart URL {string}")
	public void open_application_Cart_URL(String string) {

		launchURL(string);

	}

	@Then("Verify Redirect to login page and error message {string} displayed")
	public void verify_Redirect_to_login_page_and_error_message_displayed(String string) {

		Assert.assertTrue(l.getLoginButton().isDisplayed());

		Assert.assertTrue(getText(l.getLoginErroMessage()).contains(string));

	}


	@When("Select {string} from sort dropdown")
	public void select_from_sort_dropdown(String string) {

		if(string.equalsIgnoreCase("Name (A to Z)")) {

			selectByText(l.getSortButton(), string);
		} 

		else if (string.equalsIgnoreCase("Name (Z to A)")) {

			selectByText(l.getSortButton(), string);
		} 
		
		else if (string.equalsIgnoreCase("Price (low to high)")) {

			selectByText(l.getSortButton(), string);
		} 

		else if (string.equalsIgnoreCase("Price (high to low)")) {

			selectByText(l.getSortButton(), string);
		} 


	}


	@Then("Verify products are sorted {string}")
	public void verify_products_are_sorted(String string) {

		if(string.equalsIgnoreCase("Name (A to Z)")) {


			List<WebElement> listOfProducts = p.getListOfProducts();

			numberOfProducts =6;

			for (int i = 0; i < numberOfProducts; i++) {

				productname.add(getText(listOfProducts.get(i)));
			}

			System.out.println(productname);

			List<String> expected = new ArrayList(productname);

			Collections.sort(expected);

			System.out.println(expected);

			Assert.assertTrue(productname.equals(expected));



		} else if(string.equalsIgnoreCase("Name (Z to A)")) {


			List<WebElement> listOfProducts = p.getListOfProducts();

			numberOfProducts =6;

			for (int i = 0; i < numberOfProducts; i++) {

				productname.add(getText(listOfProducts.get(i)));
			}

			System.out.println(productname);

			List<String> expected = new ArrayList(productname);

			expected.sort(Collections.reverseOrder());

			System.out.println(expected);

			Assert.assertTrue(productname.equals(expected));



		}


		else if(string.equalsIgnoreCase("Price (high to low)")) {


			List<WebElement> listOfProductsprice = p.getListOfProductsprice();

			numberOfProducts =6;

			for (int i = 0; i < numberOfProducts; i++) {

				productPrice.add(Double.valueOf(getText(listOfProductsprice.get(i)).substring(1)));
			}

			System.out.println(productPrice);

			List<String> expected = new ArrayList(productPrice);

			expected.sort(Collections.reverseOrder());

			System.out.println(expected);

			Assert.assertTrue(productPrice.equals(expected));



		}
		
		if(string.equalsIgnoreCase("Price (low to high)")) {


			List<WebElement> listOfProductsprice = p.getListOfProductsprice();

			numberOfProducts =6;

			for (int i = 0; i < numberOfProducts; i++) {
				
				getText(listOfProductsprice.get(i)).substring(1);

				productPrice.add(Double.valueOf(getText(listOfProductsprice.get(i)).substring(1)));
			}

			System.out.println(productPrice);

			List<String> expected = new ArrayList(productPrice);

			Collections.sort(expected);

			System.out.println(expected);

			Assert.assertTrue(productPrice.equals(expected));



		}


	}

}
