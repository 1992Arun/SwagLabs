package org.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class LoginPagePOM extends BaseClass {

	public LoginPagePOM(){

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='user-name']")
	private WebElement userName;

	
	@FindBy(xpath="//div['form_group']//child::input[@id='user-name']")
	private WebElement userNameFieldValue;
	
	
	@FindBy(xpath="//div['form_group']//child::input[@id='password']")
	private WebElement passwordFieldValue;
	
	
	@FindBy(xpath="//div[@class='primary_header']//descendant::button[@id='react-burger-menu-btn']")
	private WebElement menuButton;

	@FindBy(xpath="//nav[@class='bm-item-list']//descendant::a[@id='logout_sidebar_link']")
	private WebElement logoutButton;

	@FindBy(xpath="//div[@id='shopping_cart_container']//child::span[@class='shopping_cart_badge']")
	private WebElement numberOfProductsInCart;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']//child::a[@class='shopping_cart_link']")
	private WebElement cart;

	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='password']")
	private WebElement password;

	@FindBy(xpath="//div[@class='error-message-container error']//descendant::h3[text()]")
	private WebElement loginErroMessage;

	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='login-button']")
	private WebElement loginButton;

	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement sortButton;

	@FindBy(xpath="//div[@class='login_password']/text()[normalize-space()]")
	private WebElement passwordtext;


	@FindBys({@FindBy(xpath="//div[@class='inventory_item_img']//descendant::img")})
	private List<WebElement> images;

	public static String getUser_Name(int num) {

		String text = driver.findElements(By.xpath("//div[@class='login_credentials_wrap-inner']//child::div")).get(0).getText();

		String[] split = text.split("\\r?\\n");

		return split[num];

	}


	public static String getPasswordText() {

		String text = driver.findElements(By.xpath("//div[@class='login_credentials_wrap-inner']//child::div")).get(1).getText();

		String[] split = text.split("\\r?\\n");

		return split[1];

	}

	@FindBy(xpath="//div[@class='header_secondary_container']//descendant::button[@id='back-to-products']")
	private WebElement backToProducts;


	@FindBy(xpath="//div[@class='bm-burger-button']//child::button[@id='react-burger-menu-btn']")
	private WebElement burggerMenu;


	public WebElement getBackToProducts() {
		return backToProducts;
	}


	public List<WebElement> getImages() {
		return images;
	}


	public WebElement getBurggerMenu() {
		return burggerMenu;
	}


	public WebElement getUserName() {
		return userName;
	}

	public WebElement getNumberOfProductsInCart() {
		return numberOfProductsInCart;
	}


	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getSortButton() {
		return sortButton;
	}


	public WebElement getLoginErroMessage() {
		return loginErroMessage;
	}


	public WebElement getPasswordtext() {
		return passwordtext;
	}


	public WebElement getMenuButton() {
		return menuButton;
	}


	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public WebElement getCart() {
		return cart;
	}


	public WebElement getUserNameFieldValue() {
		return userNameFieldValue;
	}


	public WebElement getPasswordFieldValue() {
		return passwordFieldValue;
	}






}
