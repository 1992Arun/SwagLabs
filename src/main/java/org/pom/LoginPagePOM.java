package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class LoginPagePOM extends BaseClass {
	
	public LoginPagePOM(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='user-name']")
	private WebElement userName;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']//child::span[@class='shopping_cart_badge']")
	private WebElement numberOfProductsInCart;
	
	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='error-message-container error']//descendant::h3[text()]")
	private WebElement loginErroMessage;
	
	@FindBy(xpath="//div[@class='login-box']//descendant::input[@id='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='login_password']/text()[normalize-space()]")
	private WebElement passwordtext;
	
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
	
	
	

	public WebElement getBackToProducts() {
		return backToProducts;
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


	public WebElement getLoginErroMessage() {
		return loginErroMessage;
	}


	public WebElement getPasswordtext() {
		return passwordtext;
	}

	


	

}
