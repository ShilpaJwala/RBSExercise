package com.demo;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		tags= {"@TestAll"}
		,plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"}
		,features = "src\\test\\java\\cucumber\\Features"
		,glue={"cucumber.StepDefinitions"}
		)
 
public class TestRunner {
	//TestRunner class
}