package com.rbs.demo.rbs;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		tags= {"@TestAll"}
		,features = "src\\test\\java\\cucumber\\Features"
		,glue={"cucumber.StepDefinitions"}
		)
 
public class TestRunner {
	//TestRunner class
}