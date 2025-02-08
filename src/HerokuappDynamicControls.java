import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.*;

public class HerokuappDynamicControls {
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
    public void testDynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Test removing the checkbox
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        removeButton.click();

        // Wait for the checkbox to be removed
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(message.getText().contains("It's gone!"));
        assertTrue(driver.findElements(By.xpath("//input[@type='checkbox']")).isEmpty());

        // Test adding the checkbox back
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addButton.click();

        // Wait for the checkbox to reappear
        message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(message.getText().contains("It's back!"));
        checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        assertNotNull(checkbox);

        // Test enabling the text field
        WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
        enableButton.click();

        // Wait for the text field to be enabled
        message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(message.getText().contains("It's enabled!"));
        assertTrue(textField.isEnabled());

        // Test disabling the text field
        WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(), 'Disable')]"));
        disableButton.click();

        // Wait for the text field to be disabled
        message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(message.getText().contains("It's disabled!"));
        assertFalse(textField.isEnabled());
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
