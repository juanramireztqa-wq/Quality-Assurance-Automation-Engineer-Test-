# Quality Assurance Automation Engineer Test
This project is the solution to the **Quality Assurance Automation Engineer Assessment** for **ScotiaTech**.  

It specifically corresponds to the **automation of Test Case TC‑8 (Complete checkout flow for purchasing a single product)** from the manual testing section of the assessment.

It automates the complete checkout flow on [saucedemo.com](https://www.saucedemo.com) using **Selenium WebDriver**, **Cucumber BDD**, and **Allure Reports**.  

It validates product selection, cart management, checkout, and generates professional reports with visual evidence (screenshots).

---
## Methodology
The project follows the **Page Object Model (POM)** design pattern.  
This approach separates test logic from page structure, making the automation framework:
- Easier to maintain  
- More reusable  
- Cleaner and scalable for future test cases  

---

## Technologies
- Java 17  
- Selenium WebDriver  
- Cucumber BDD  
- Allure Reports  
- Gradle

---

## Installation

Clone the repository and navigate into the project folder:
```bash
git clone https://github.com/your-username/SeleniumScotiaAssessment.git
 ````
```bash
cd SeleniumScotiaAssessment
````
## Running Tests

1. Clean and run the test suite:
```bash
./gradlew clean test
````
This executes all Cucumber scenarios and generates raw results in the allure-results folder.

## Important Note
To generate and view reports, Allure must be installed on your system.

* On macOS: brew install allure
* On Windows: scoop install allure
* On Linux: download from the Allure releases (github.com in Bing) page and add it to your PATH.

---

2. Generate the Allure HTML report:
```bash
allure generate allure-results -o build/allure-report
````
This processes the raw results and creates a full HTML report inside build/allure-report.

3. Open the report in your browser:
```bash
allure open build/allure-report
````
The report will launch locally and display test suites, steps, logs, and screenshots.

---
## Project Structure
```bash
test/
├── java/
│   ├── page_objects        # Page Object Model classes
│   ├── runners             # Test runners
│   ├── step_definitions    # Step definitions for Cucumber
│   └── utils               # Helpers and utilities
└── resources/
    └── feature_files       # Cucumber feature files (.feature)
````


## Notes
This repository was created as part of the **Quality Assurance Automation Engineer Assessment** for **ScotiaTech**.  
It is intended solely for technical evaluation purposes and does not represent a production-ready framework.









