package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    }

    /**
     * Uses the search bar to look for the searchValue and move into it.
     * @param searchValue is the string used to search.
     */
    public void useSearchBar(String searchValue){
        // Wait until the search button is visible, then click, enter the search value, and submit.
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        searchButton.sendKeys(searchValue);
        searchButton.submit();
    }
}
