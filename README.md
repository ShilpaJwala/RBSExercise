# RBS Test Automation Practice

This is a BDD based tes-automation project to automate the following charters:
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

## Execution Instructions

The project is broken into separate modules for API, UI, Performance and Security testing. Each of these modules can be utilised independently of the others using maven profiles.

To run all modules, navigate to `rbs` directory and run:

`mvn clean install`

## Reporting

Reports for each module are written into `/target` directories after a successful run.

