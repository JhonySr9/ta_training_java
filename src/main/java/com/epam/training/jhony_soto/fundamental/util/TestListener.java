package com.epam.training.jhony_soto.fundamental.util;

import com.epam.training.jhony_soto.fundamental.driver.DriverInitialization;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TestListener class implements the ITestListener interface to provide test status monitoring
 * and screenshot capture functionality.
 */
public class TestListener implements ITestListener {
    private final Logger log = LogManager.getRootLogger();
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 1;

    /**
     * Resets the retry count to zero at the start of each test method.
     *
     * @param result The result object representing the current test method.
     */
    public void onTestStart(ITestResult result) {
        retryCount = 0; // Reset retry count at the start of each test
    }

    /**
     * Logs a message when a test method succeeds.
     *
     * @param result The result object representing the current test method.
     */
    public void onTestSuccess(ITestResult result) {
        log.info("Test Passed: " + result.getName());
    }

    /**
     * Saves a screenshot and logs an error message when a test method fails.
     * Retries the test method based on the retry logic.
     *
     * @param result The result object representing the current test method.
     */
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result);
        log.error("Test Failed: " + result.getName());
        retryOrSkipTest(result);
    }

    /**
     * Logs a warning message when a test method is skipped.
     *
     * @param result The result object representing the current test method.
     */
    public void onTestSkipped(ITestResult result) {
        log.warn("Test Skipped: " + result.getName());
    }

    /**
     * Saves a screenshot of the WebDriver instance when a test method fails.
     *
     * @param result The result object representing the current test method.
     */
    private void saveScreenshot(ITestResult result){
        String testName = result.getMethod().getMethodName();
        String environment = System.getProperty("environment");
        String browser = System.getProperty("browser");
        File screenCapture = ((TakesScreenshot) DriverInitialization.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/" + testName + "_" + environment + "_" + browser + "_" + getCurrentTimeAsString() + ".png"
            ));
        } catch (IOException e){
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    /**
     * Implements the retry logic for failed test methods.
     *
     * @param result The result object representing the current test method.
     * @return True if the test method should be retried, false otherwise.
     */
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }

    /**
     * Retries or skips the test method based on the retry logic.
     *
     * @param result The result object representing the current test method.
     */
    private void retryOrSkipTest(ITestResult result) {
        if (retry(result)) {
            result.setStatus(ITestResult.FAILURE); // Mark the test as failed to trigger retry
        } else {
            result.setStatus(ITestResult.FAILURE); // If retries exhausted, mark as failure
        }
    }

    /**
     * Retrieves the current time as a formatted string.
     *
     * @return The current time formatted as "yyyy-MM-dd HH-mm-ss".
     */
    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
