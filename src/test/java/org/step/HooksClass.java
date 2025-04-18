package org.step;

import java.util.LinkedList;

import org.pom.ChecOutPage;
import org.pom.LoginPagePOM;
import org.pom.ProductsPage;
import org.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	
	@Before()
		public void setUp() {
	
		browserLaunch("Chrome");

		l = new LoginPagePOM();
		
		p = new ProductsPage();
		
		checkout = new ChecOutPage();
		
		productname =  new LinkedList();
		
		productPrice =  new LinkedList();
			
		}
		
		
	@After()
	
		public void tearDown() {
			
		//	driver.quit();
		
	}

}
