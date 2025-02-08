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
import static org.junit.Assert.*;

import java.time.Duration;

public class SauceDemoCheckoutTest {
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
    public void testCompletePurchaseProcess() {
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Logging in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Find the product and add to cart without visiting the product page
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        addToCartButton.click();

        // Navigate to the cart
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        // Verify the product in the cart
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")));
        assertNotNull(cartItem);

        // Proceed to checkout
        driver.findElement(By.id("checkout")).click();

        // Fill in the checkout form
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Finalize the order
        driver.findElement(By.id("finish")).click();

        // Verify order confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your order!']")));
        assertTrue(confirmationMessage.isDisplayed());
    }

    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
