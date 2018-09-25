# RBS Test Automation Practice

This is a BDD based tes-automation project which uses Page Object Model design pattern. The purpose of the project is to automate the following charters:
* Scenario 1: Order T-Shirt (and Verify in Order History)
* Scenario 2: Update Personal Information (First Name) in My Account


## Tools

* Maven
* Cucumber
* JUnit
* Selenium Webdriver

## Requirements

In order to utilise this project you need to have the following installed locally:

* Maven 3
* Java 1.8

Or

this project can be run as a standalone project from eclipse or any other IDE.

## Test Structure 

* **src\test\java\cucumber\Features** - all the cucumber features files (files .feature ext) goes here.
* **src\test\java\cucumber\StepDefinitions** - you can define step defintion under this package for your feature steps.
* **src\test\java\com\demo** - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml).
* **config.properties** - properties file with username/password, file/dir names


## Execution Instructions

The project is broken into separate modules for API, UI, Performance and Security testing. Each of these modules can be utilised independently of the others using maven profiles.

To run all modules, navigate to `rbs` directory and run:

`mvn clean install`

## Reporting

Reports for each module are written into `/target` directories after a successful run.

