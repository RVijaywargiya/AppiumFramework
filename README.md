# Appium Test Automation Framework

## Overview
This repository contains a test automation framework built using Appium, Java, TestNG, Log4j2, Extent Reports, JSON for data, and Maven. The framework is designed to automate mobile application testing, providing a scalable and maintainable solution for Android and iOS platforms.

## Features

- **Appium:** The framework utilizes Appium as the mobile automation tool, supporting both Android and iOS platforms.

- **Java:** The programming language used for writing test scripts and implementing the automation logic.

- **TestNG:** TestNG is used as the testing framework to organize and execute test cases efficiently.

- **Log4j2:** Logging is implemented using Log4j2 to capture detailed logs for debugging and analysis.

- **Extent Reports:** HTML-based Extent Reports are integrated to generate detailed and visually appealing test listeners.

- **JSON for Data:** JSON files are used for storing test data, making it easy to manage and update test data separately from the test scripts.

- **Maven:** Maven is employed as the build and dependency management tool for the project.

## Getting Started

### Prerequisites
- Make sure you have Java installed. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

- Install Maven by following the instructions [here](https://maven.apache.org/install.html).

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/RVijaywargiya/AppiumFramework.git

2. **Appium Server:**
   - Install Appium Server by following the instructions on the [official Appium documentation](http://appium.io/docs/en/about-appium/intro/).

3. **Mobile Emulators or Devices:**
   - Ensure that you have the necessary emulators or physical devices set up for testing. Refer to the Appium documentation for configuring emulators or connecting physical devices.

4. **Project Configuration:**
   - Open the `src/test/resources/config` directory and review the configuration files.
   - Adjust the settings in `appium-config.properties` to match your Appium server configuration, such as server URL, platform name, device name, etc.

5. **Test Data Configuration:**
   - Navigate to the `src/test/resources/data` directory and update the JSON files with relevant test data.
   - Modify the data in these files according to the requirements of your test scenarios.

6. **Environment Variables:**
   - Check if there are any environment-specific configurations required and set up corresponding environment variables if necessary.

7. **Build Project:**
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```

Now, your environment should be set up for running tests with the Appium test automation framework.

## Running Tests

Now that the framework is set up, you can execute the test suite using Maven:

```bash
mvn test
