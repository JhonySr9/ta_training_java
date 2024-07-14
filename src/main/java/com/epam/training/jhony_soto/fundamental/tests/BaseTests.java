package com.epam.training.jhony_soto.fundamental.tests;

import com.epam.training.jhony_soto.fundamental.driver.DriverInitialization;
import com.epam.training.jhony_soto.fundamental.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Base test class for Google Cloud tests.
 * This class sets up the WebDriver and WebDriverWait for the tests.
 */

@Listeners({TestListener.class})
public class BaseTests {

    protected WebDriver driver;
    protected final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected final String PRICING_CALCULATOR_SEARCH_VALUE = "Google Cloud Pricing Calculator";
    protected final String SUMMARY_TAB_NAME = "Google Cloud Estimate Summary";
    protected final String PROVISIONING_MODEL_REGULAR_OPTION = "Regular";
    protected final String COMMITTED_USAGE_1YEAR_OPTION = "1 year";

    /**
     * Sets up global system properties before running the test suite.
     * It initializes properties such as "browser" and "environment".
     * Adjusts these properties according to test environment needs.
     */
    @BeforeSuite (groups = {"setUp"})
    public void setProperties(){
        System.setProperty("browser", "chrome");
        System.setProperty("environment", "dev");
    }

    /**
     * Configures WebDriver before starting each test method.
     * Sets up the ChromeDriver instance using DriverInitialization.
     */
    @BeforeMethod (groups = {"setUp"})
    public void setUp(){
        driver = DriverInitialization.getDriver();
        driver.manage().window().maximize();
    }

    /**
     * Closes WebDriver after finishing each test method.
     * Ensures the WebDriver instance quits if it is not null.
     */
    @AfterMethod (groups = {"setUp"})
    public void turnOff(){
        DriverInitialization.closeDriver();
    }

    /**
     * Navigates to the specified URL.
     *
     * @param URL The URL to navigate to.
     */
    public void goToURL(String URL){
        driver.get(URL);
    }
}
