import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class HerokuappDropdownTest {
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
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        WebElement option1 = driver.findElement(By.xpath("//option[@value='1']"));
        option1.click();
        assertTrue(option1.isSelected());

        WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));
        option2.click();
        assertTrue(option2.isSelected());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
