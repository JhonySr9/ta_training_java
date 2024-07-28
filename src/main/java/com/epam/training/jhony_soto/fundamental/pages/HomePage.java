package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

/**
 * This class represents the home page of Google Cloud and provides methods to interact with it.
 */

public class HomePage extends AbstractPage {

    @FindBy (xpath = "//input[@name='q']")
    private WebElement searchButton;

    /**
     * Constructor for HomePage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public HomePage(WebDriver driver) {
        super(driver);
        log.info("HomePage initialized with driver.");
    }

    /**
     * Uses the search bar to look for the provided search value and submits the search.
     * Waits until the search button is visible and clickable, then clicks it, enters the search value, and submits.
     *
     * @param searchValue the string used to search.
     * @throws NoSuchElementException if the search button or input field is not found.
     * @throws Exception if any other error occurs while using the search bar.
     */
    public void useSearchBar(String searchValue){
        try {
            // Wait until the search button is visible and clickable
            WebElement searchBtn = wait.until(ExpectedConditions.visibilityOf(searchButton));

            // Click the search button
            searchBtn.click();

            // Enter the search value
            searchBtn.sendKeys(searchValue);

            // Submit the search
            searchBtn.submit();

        }   catch (NoSuchElementException e) {
            log.error("Failed to find the element containing the value: " + searchValue, e);
            throw e;
        }   catch (Exception e) {
            log.error("Failed to use search bar with value: " + searchValue, e);
            throw e;
        }
    }
}
