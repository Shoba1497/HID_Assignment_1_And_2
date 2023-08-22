package com.testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(features = {"src\\test\\resources"},
dryRun =false ,glue = "com.stepdefinition", plugin = { "pretty", "html:target/cucumber-reports.html" },
monochrome = true

)



public class Testrunner {
	
	
}
