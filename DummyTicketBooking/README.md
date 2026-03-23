# Selenium Java Automation Project - Dummy Ticket

This project is the final practical application for the Selenium with Java section of the Udemy course: "Mastering Selenium with Java": https://www.udemy.com/course/selenium-with-java-ar/.

## Project Overview
The goal of this project is to automate the ticket booking process on the Dummy Ticket website. It covers selecting ticket options, entering passenger details, handling travel information, and managing secure payment fields.

## Key Automation Concepts Applied
- Page Object Model (POM): Separation of test scripts from page-specific locators and methods for better maintainability.
- Explicit Waits: Used WebDriverWait to handle element synchronization and ensure test stability without using Thread.sleep.
- iFrame Handling: Implemented context switching to interact with secure credit card fields hosted inside Stripe iFrames.
- Selenium Native Scrolling: Utilized the Actions class to perform automatic scrolling to elements before interaction.
- Dynamic Locators: Handled complex elements using flexible XPath and CSS Selectors.

## Future Work & Next Steps
Currently, the project focuses purely on browser automation and element interaction using Selenium. As I progress through the upcoming testing sections of the course, the following enhancements will be implemented:

- Implementing Assertions: Add robust validation points (Hard and Soft Assertions) to verify expected outcomes, such as success messages and error notifications.
- Comprehensive Test Cases: Design and execute specific Positive (Happy Path) and Negative test scenarios.
- Data-Driven Testing (DDT): Extract hardcoded test data into external files (Excel or JSON) to run scenarios with multiple datasets.
- Test Reporting: Integrate reporting tools (like ExtentReports or Allure) to generate detailed, readable HTML test execution reports.