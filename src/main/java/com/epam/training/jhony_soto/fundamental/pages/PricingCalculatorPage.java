package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the Google Cloud Pricing Calculator page and provides methods to interact with it.
 */
public class PricingCalculatorPage extends AbstractPage {

    @FindBy (xpath = "//span[normalize-space(text())='Add to estimate']")
    private WebElement addAnEstimateButton;

    @FindBy (xpath = "//div[@data-idx='0']")
    private WebElement computeEngineOption;

    /**
     * Constructor for PricingCalculatorPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public PricingCalculatorPage(WebDriver driver){
        super(driver);
        log.info("PricingCalculatorPage initialized with driver.");
    }

    /**
     * Clicks the "Add to estimate" button on the Pricing Calculator page.
     */
    public void pressAddAnEstimateButton(){
        try {
            wait.until(ExpectedConditions.visibilityOf(addAnEstimateButton));
            addAnEstimateButton.click();

        }   catch (Exception e) {
            log.error("The 'Add to estimate' button was not clicked due to an Exception", e);
            throw e;
        }
    }

    /**
     * Navigates to the Compute Engine Page.
     * Waits until the compute engine option is visible, then clicks it.
     *
     * @throws Exception if an error occurs while navigating to the Compute Engine Page.
     */
    public void openComputeEnginePage(){
        try {
            wait.until(ExpectedConditions.visibilityOf(computeEngineOption));
            computeEngineOption.click();
        }   catch (Exception e) {
            log.error("Failed to navigate to the Compute Engine Page.", e);
            throw e;
        }

    }
}
