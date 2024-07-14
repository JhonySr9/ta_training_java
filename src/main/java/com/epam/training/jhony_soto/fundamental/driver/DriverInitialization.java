package com.epam.training.jhony_soto.fundamental.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Utility class for managing WebDriver instances.
 * Configures and provides WebDriver based on the specified browser property.
 */
public class DriverInitialization {

    private static WebDriver driver;

    /**
     * Retrieves and configures the WebDriver instance based on the specified browser.
     * If no browser is specified or recognized, defaults to ChromeDriver.
     * Initializes and maximizes the browser window.
     *
     * @return WebDriver instance configured based on the browser property.
     */
    public static WebDriver getDriver(){

        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
            }
        }
        return driver;
    }

    /**
     * Closes the WebDriver instance if it is not null.
     * Quits the browser window to ensure resources are released.
     */
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null; // Reset driver instance after quitting.
        }
    }
}
