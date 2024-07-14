package com.epam.training.jhony_soto.fundamental.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * Abstract base class for all page objects.
 * Initializes WebDriverWait and PageFactory elements for derived page classes.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    protected static final Logger log = LogManager.getRootLogger();

    /**
     * Constructor for AbstractPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    /**
     * Gets the option element to select from a list based on the provided option text.
     *
     * @param option The text of the option to select.
     * @return The WebElement representing the option.
     */
    public WebElement getOptionToSelect(String option) {
        log.info("Getting option to select: " + option);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//li[contains(., '" + option + "')]")
            ));
        } catch (Exception e) {
            log.error("Option not found: " + option, e);
            throw e;
        }
    }

    /**
     * Switches to the browser tab with the specified title.
     * If the tab with the specified title is not found, logs a warning.
     *
     * @param tabTitle the title of the tab to switch to
     */
    public void changeToOtherTab(String tabTitle) {
        log.info("Changing to tab with title: " + tabTitle);
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (tabTitle.equals(driver.getTitle())) {
                log.info("Switched to tab with title: " + tabTitle);
                return;
            }
        }
        log.warn("Tab with title not found: " + tabTitle);
    }
}