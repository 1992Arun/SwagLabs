package org.utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.ChecOutPage;
import org.pom.LoginPagePOM;
import org.pom.ProductsPage;

public class BaseClass {

	public static WebDriver driver;
	
	public static LoginPagePOM l;
	
	public static ProductsPage p;
	
	public static List<String> productname;
	
	public static List<Double> productPrice;
	
	public static ChecOutPage checkout;
	
	public static String userName;
	
	public static String password;
	
	public static int numberOfProducts;
	
	public static WebDriver browserLaunch(String browser) {
		
		Map<String, Object> mp = new LinkedHashMap();
		
		mp.put("profile.password_manager_enabled", false);
		
		mp.put("credentials_enable_service", false);

		//		if(driver==null) {

		ChromeOptions op = new ChromeOptions();
		
		op.addArguments("--disable-logging");
		op.addArguments("--log-level=3");
		
		op.setExperimentalOption("prefs", mp);

		//	op.addArguments("--headless");
		
		op.addArguments("--incognito");
		
		op.addArguments("--start-Maximized");
		
		op.addArguments("--disable-notifications");
		
		

		switch( browser) {

		case "Chrome": driver = new ChromeDriver(op);
		
		
		

		break;



		case "Edge": driver = new EdgeDriver();

		break;

		}

		return driver;
	}

	//	}

	public static void movetoElement(WebElement e) {

		Actions a = new Actions(driver);

		a.moveToElement(e).perform();

	}

	public static void offset(WebElement e) {

		Actions a = new Actions(driver);

		a.moveByOffset(100, 100).click(e);

	}

	public static void TAB() {

		Actions a = new Actions(driver);

		a.sendKeys(Keys.TAB).perform();

	}


	public static String launchURL(String url) {


		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return url;

	}

	public static String getCurrentURL() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void aSendKeys(String value) {

		Actions a = new Actions(driver);

		a.click().sendKeys(value).perform();

	}

	public static void sendKeys(WebElement e, String value) {

		try {

			e.sendKeys(value);

		}catch(Exception a) {

			JavascriptExecutor js = (JavascriptExecutor)driver;

			js.executeScript("arguments[0].value='"+value+"';", e);

		}

	}
	
	
	public static void acceptAlert() {
		
		driver.switchTo().alert().accept();
	}


	public static void click(WebElement e) {

		try {

			//			e.click();

			JavascriptExecutor js = (JavascriptExecutor)driver;


			js.executeScript("arguments[0].click();", e);

		}catch(Exception a) {

			JavascriptExecutor js = (JavascriptExecutor)driver;


			js.executeScript("arguments[0].click();", e);

		}

	}

	public static String getText(WebElement e) {

		String text = e.getText();


		return text;

	}

	public static String getAttribute(WebElement e, String name) {

		String text = e.getAttribute(name);


		return text;

	}

	public static String takeScreenShots(String name) {

		SimpleDateFormat sd =  new SimpleDateFormat("dd/MM/yyyy/hh/mm/ss");

		TakesScreenshot ts = (TakesScreenshot)driver;

		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotAs, new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loc = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";		

		return loc;

	}


	public static void selectByIndex(WebElement e, int num){

		Select s = new Select(e);

		s.selectByIndex(num);

	}


	public static void selectByValue(WebElement e, String value){

		Select s = new Select(e);

		s.selectByValue(value);

	}


	public static void selectByText(WebElement e, String value){

		Select s = new Select(e);

		s.selectByVisibleText(value);

	}

	public static String getSelectedValue(WebElement e, int index){

		Select s = new Select(e);

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();

		String text = allSelectedOptions.get(index).getText();


		return text;

	}

	public static void switchWindow(int num){

		List<String> li = new LinkedList<String>();

		try {

			String windowHandle = driver.getWindowHandle();

			Set<String> windowHandles = driver.getWindowHandles();

			for(String x:windowHandles) {

				if(!windowHandle.equals(x)) {

					driver.switchTo().window(x);

				}

			}

		}catch(NoSuchElementException a) {


			Set<String> windowHandles = driver.getWindowHandles();

			String windowHandle = driver.getWindowHandle();

			int count=1;

			for(String x:windowHandles) {

				if(count==num) {

					driver.switchTo().window(x);

				}

				count++;

			}

		} catch(Exception a) {



			Set<String> windowHandles = driver.getWindowHandles();

			li.addAll(windowHandles);

			driver.switchTo().window(li.get(num));

		}


	}

	public static void swithToNextWindow() {

		String parent = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		int count=0;

		int num = 0;

		for(String x: windowHandles) {

			if(x.contains(parent)) {

				num=count;
			}

			count++;	
		}

		int count1=1;

		for(String x:windowHandles) {

			if(count1==num+1) {

				driver.switchTo().window(x);

			}

			count1++;

		}


	}

	public static void doublClick() {

		Actions a = new Actions(driver);

		a.doubleClick();
	}

	public static void quit(){

		driver.quit();

	}

	public static void sleep(int num){

		int time= num*1000;

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static WebElement webDriverWait(int duration, WebElement e ) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		return  wait.until(ExpectedConditions.visibilityOf(e));

	}

	public static void accepteAlert() {

		driver.switchTo().alert().accept();

	}

	public static void dismissAlert() {

		driver.switchTo().alert().dismiss();;

	}

	public static void scrollUp(WebElement e ) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", e);

	}
	
	public static void scrollDown(WebElement e ) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	
	public static void ActionSendKeys(WebElement e, String text) {
		
		Actions a = new Actions(driver);
		
		
		a.click(e).sendKeys(Keys.BACK_SPACE).sendKeys(text).perform();
		
		
	}
	
	


}

