package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Abstract base class for all page objects.
 * Initializes WebDriverWait and PageFactory elements for derived page classes.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

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

}
