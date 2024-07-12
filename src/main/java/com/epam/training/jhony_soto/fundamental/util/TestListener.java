package com.epam.training.jhony_soto.fundamental.util;

import com.epam.training.jhony_soto.fundamental.driver.DriverInitialization;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
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

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result The result of the test that failed.
     */
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result);
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

    /**
     * Saves a screenshot when a test fails.
     *
     * @param result The result of the test that failed.
     */
    private void saveScreenshot(ITestResult result){
        String testName = result.getMethod().getMethodName();
        String environment = System.getProperty("environment");
        File screenCapture = ((TakesScreenshot) DriverInitialization.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/" + testName + "_" + environment + "_"+ getCurrentTimeAsString() + ".png"
            ));
        } catch (IOException e){
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
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
