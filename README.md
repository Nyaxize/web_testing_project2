# Selenium Test Framework (Java + JUnit)

## 📖 Description
This project is a Selenium-based test framework for automating web application testing using Java and JUnit. It includes example tests for login validation, purchase flow on SauceDemo, and dynamic controls testing on Herokuapp.

## ⚙️ Requirements
- Java Development Kit (JDK) 17 or higher
- Chrome browser (version 114.0.5735.90 or compatible)
- ChromeDriver (matching your Chrome browser version)
- Selenium and JUnit libraries (included in the `lib/` folder)

## 🛠 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Nyaxize/web_testing_project2.git
   cd web_testing_project2
   ```

2. **Add ChromeDriver:**
   - Download the version of ChromeDriver matching your Chrome browser from [ChromeDriver Downloads](https://chromedriver.chromium.org/downloads).
   - Place the `chromedriver.exe` file in the root folder of your project (or set its path in the code).

3. **Set up your development environment:**
   - Use Visual Studio Code or any other Java IDE.
   - Ensure `src/` and `lib/` are added to your project's classpath.

## 📂 Project Structure
```
java_web_testing_project/
│
├── lib/                  # Selenium and JUnit library dependencies
├── src/                  # Source code for tests
│   ├── HerokuappLoginTest.java       # Test for Herokuapp login page
│   ├── HerokuappDynamicControlsTest.java  # Test for dynamic controls
│   ├── HerokuappDropdownTest.java         # Test for dropdown selection
│   ├── SauceDemoCheckoutTest.java         # Test for SauceDemo purchase flow
└── .gitignore            # Files to be ignored by Git
```

## 🚀 How to Run Tests

1. **Compile the tests:**
   ```bash
   javac -cp "lib/*;src" -d bin src/*.java
   ```

2. **Run a specific test:**
   ```bash
   java -cp "lib/*;bin" org.junit.runner.JUnitCore SauceDemoCheckoutTest
   ```
   
## 📝 Notes
- Ensure that your ChromeDriver version matches the installed version of Chrome.
- The `lib/` folder already contains the required `.jar` files for Selenium and JUnit.
- If you encounter issues, check the browser and WebDriver compatibility or update paths in the code.

### Happy Testing! 🚀

