package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the results page of Google Cloud and provides methods to interact with it.
 */
public class ResultsPage extends AbstractPage {

    /**
     * Constructor for ResultsPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public ResultsPage(WebDriver driver) {
        super(driver);
        log.info("ResultsPage initialized with driver.");
    }

    /**
     * Selects the search result based on the specified search value.
     *
     * @param searchValue The string value to search and click.
     */
    public void selectSearchResult(String searchValue) {
        String searchResultXpath = "//a[normalize-space()='" + searchValue + "']";

        try {
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultXpath)));
            log.info("Search result with '" + searchValue + "' value is visible.");
            searchResult.click();
            log.info("Clicked on the search result '" + searchValue + "'.");
        } catch (Exception e) {
            log.error("Failed to click on the search result '" + searchValue + "'.", e);
        }
    }
}
