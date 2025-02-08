import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class HerokuappLoginTest {
    private WebDriver driver;
    
    @Before
    public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\ZajeciaPotemDoUsuniecia\\java\\Web_testing_projekt\\chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Users\\Damian\\chrome\\win64-114.0.5735.90\\chrome-win64\\chrome.exe");

    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    }
    
    @Test
    public void testValidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();
        
        WebElement successMessage = driver.findElement(By.id("flash"));
        assertTrue(successMessage.getText().contains("You logged into a secure area!"));
    }
    
    @Test
    public void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        username.sendKeys("invalidUser");
        password.sendKeys("wrongPassword");
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.id("flash"));
        assertTrue(errorMessage.getText().contains("Your username is invalid!"));
    }

    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
