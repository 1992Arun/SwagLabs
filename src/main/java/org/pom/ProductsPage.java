package org.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class ProductsPage extends BaseClass {

	public ProductsPage(){

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@id='header_container']//following::span[@data-test='title']")
	private WebElement ProductsText;

	
	@FindBy(xpath="//div[@class='cart_footer']//child::button[@id='continue-shopping']")
	private WebElement continueShoping;

	@FindBys({@FindBy(xpath="//div[@class='inventory_item_label']//following::button[text()='Add to cart']")})
	private List<WebElement> addToCartButton;

	@FindBys({@FindBy(xpath="//div[@class='inventory_item_description']//child::div[@class='inventory_item_name ']")})
	private List<WebElement> listOfProducts;

	public static WebElement ListOfProducts(int num) {

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='inventory_item_description']//child::div[@class='inventory_item_name ']"));

		return findElements.get(num);


	}

	public static WebElement product(String name) {

		return  driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='"+name+"']"));

	}


	public static WebElement productAddToCart(String productName) {

		return  driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='"+productName+"']//ancestor::div[@class='inventory_item_label']//following-sibling::div//button"));

	}
	
	public static WebElement productRemove(String productName) {

		return  driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+productName+"']//ancestor::div[@class='cart_item_label']//following::button[text()='Remove']"));

	}
	
	@FindBys({@FindBy(xpath="//div[@class='cart_item']//following::div[@class='inventory_item_name']")})
	private List<WebElement> listOfCartProducts;

	@FindBys({@FindBy(xpath="//div[@class='inventory_item']//following::div[@class='inventory_item_price']")})
	private List<WebElement> listOfProductsprice;



	@FindBy(xpath="//div[@class='inventory_details_desc_container']//following::button")
	private WebElement addToCartRemoveButton;



	public WebElement getContinueShoping() {
		return continueShoping;
	}

	@FindBy(xpath="//div[@class='inventory_details_desc_container']//following::button")
	private WebElement RemoveButtonInCart;


	@FindBy(xpath="//div[@class='header_secondary_container']//child::button[@id='back-to-products']")
	private WebElement backToProducts;



	@FindBy(xpath="//div[@class='header_label']//following::div[@id='shopping_cart_container']//a")
	private WebElement cartButton;


	public WebElement getCartButton() {
		return cartButton;
	}


	public List<WebElement> getAddToCartButton() {
		return addToCartButton;
	}


	public WebElement getProductsText() {
		return ProductsText;
	}



	public WebElement getRemoveButtonInCart() {
		return RemoveButtonInCart;
	}


	public List<WebElement> getListOfCartProducts() {
		return listOfCartProducts;
	}

	public WebElement getBackToProducts() {
		return backToProducts;
	}


	public List<WebElement> getListOfProducts() {
		return listOfProducts;
	}


	public WebElement getAddToCartRemoveButton() {
		return addToCartRemoveButton;
	}


	public List<WebElement> getListOfProductsprice() {
		return listOfProductsprice;
	}





}
