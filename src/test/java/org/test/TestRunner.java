package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utility.Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="org.step", dryRun=false, tags="@AllUsers and @valid", monochrome=true,  plugin= {"pretty", "json:src/test/resources/Reports/new.json",
		
                                                                                                            "rerun:src/test/resources/Reports/failed.txt" })
public class TestRunner {
	 
	@AfterClass
	public static void jvmReport() {
		
		Utility.jvmReport("src/test/resources/Reports/new.json");
		
	}
	
	

}
