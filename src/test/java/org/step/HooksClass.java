package org.step;

import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pom.ChecOutPage;
import org.pom.LoginPagePOM;
import org.pom.ProductsPage;
import org.utility.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	
	@Before()
		public void setUp() {
	
		browserLaunch("Chrome");

		l = new LoginPagePOM();
		
		p = new ProductsPage();
		
		checkout = new ChecOutPage();
		
		productname =  new ArrayList();
		
		productPrice =  new ArrayList();
			
		}
		
		
	@After()
	
		public void tearDown(Scenario sc) {
		
		if(sc.isFailed()) {
			
			TakesScreenshot tk = (TakesScreenshot)driver;
			
			byte[] screenshotAs = tk.getScreenshotAs(OutputType.BYTES);
			
			sc.embed(screenshotAs, "images/png");
					
			
		}
			
		//	driver.quit();
		
	}

}
