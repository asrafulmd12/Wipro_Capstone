package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    
    public WebDriver getDriver() {
    	return driver;
    }
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = DriverFactory.initializeDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(0));

        driver.get("https://testautomationpractice.blogspot.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}