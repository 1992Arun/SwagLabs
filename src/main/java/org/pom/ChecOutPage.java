package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class ChecOutPage extends BaseClass {
	
	
public ChecOutPage(){
		
		PageFactory.initElements(driver, this);
		
	}


@FindBy(xpath="//div[@class='cart_footer']//following::button[@id='checkout']")
private WebElement checkOutButton;

@FindBy(xpath="//div[@class='summary_info']//following::div[@class='summary_subtotal_label']")
private WebElement itemTotalPrice;

@FindBy(xpath="//div[@class='checkout_info']//child::input[@id='first-name']")
private WebElement firstName;

@FindBy(xpath="//div[@class='checkout_info']//child::input[@id='last-name']")
private WebElement lastName;

@FindBy(xpath="//div[@class='checkout_info']//child::input[@id='postal-code']")
private WebElement zipCode;

@FindBy(xpath="//div[@class='checkout_buttons']//child::input[@id='continue']")
private WebElement continueButton;

@FindBy(xpath="//div[@class='cart_footer']//child::button[@id='finish']")
private WebElement finishButton;


@FindBy(xpath="//div[@id='checkout_complete_container']//following::h2")
private WebElement orderPlacedSuccessMessage;

@FindBy(xpath="//div[@id='checkout_complete_container']//child::button[@id='back-to-products']")
private WebElement backHomeButton;


@FindBy(xpath="//div[@class='summary_subtotal_label']//following::div[@class='summary_total_label' and text()]")
private WebElement totalWithTax;



@FindBy(xpath="//div[@class='summary_subtotal_label']//following::div[@class='summary_tax_label' and contains(text(),'Tax')]")
private WebElement tax;


@FindBys({@FindBy(xpath="//div[@class='cart_item']//following::a[@id]")})
private List<WebElement> cartProducts;


@FindBys({@FindBy(xpath="//div[@class='cart_item_label']//following::div[@class='inventory_item_price']")})
private List<WebElement> cartProductsPrice;



public WebElement getTax() {
	return tax;
}



public List<WebElement> getCartProductsPrice() {
	return cartProductsPrice;
}



public List<WebElement> getCartProducts() {
	return cartProducts;
}



public WebElement getFirstName() {
	return firstName;
}



public WebElement getLastName() {
	return lastName;
}



public WebElement getZipCode() {
	return zipCode;
}



public WebElement getContinueButton() {
	return continueButton;
}



public WebElement getFinishButton() {
	return finishButton;
}



public WebElement getBackHomeButton() {
	return backHomeButton;
}



public WebElement getCheckOutButton() {
	return checkOutButton;
}



public WebElement getItemTotalPrice() {
	return itemTotalPrice;
}



public WebElement getTotalWithTax() {
	return totalWithTax;
}



public WebElement getOrderPlacedSuccessMessage() {
	return orderPlacedSuccessMessage;
}




}
