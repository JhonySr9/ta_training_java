package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the Google Cloud Compute Engine page and provides methods to interact with it.
 */
public class ComputeEnginePage extends AbstractPage {

    @FindBy(xpath = "//input[@id='c13']")
    private WebElement numberOfInstancesBar;

    @FindBy(xpath = "//label[contains(normalize-space(), 'Regular')]")
    private WebElement provisioningModel_regularOption;

    @FindBy(xpath = "//div[@aria-describedby='c22']")
    private WebElement operatingSystemBar;

    @FindBy(xpath = "//div[@aria-describedby='c26']")
    private WebElement machineFamilyBar;

    @FindBy(xpath = "//div[@aria-describedby='c30']")
    private WebElement seriesBar;

    @FindBy(xpath = "//div[@aria-describedby='c34']")
    private WebElement machineTypeBar;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']//span[@class='eBlXUe-hywKDc']")
    private WebElement addGPUButton;

    @FindBy(xpath = "//div[@aria-describedby='c42']")
    private WebElement localSSDBar;

    @FindBy(xpath = "//div[@aria-describedby='c46']")
    private WebElement dataCenterLocationBar;

    @FindBy(xpath = "//label[@for='1-year']/ancestor::div[contains(@class, 'e2WL2b')]")
    private WebElement committedUse_oneYearOption;

    @FindBy(xpath = "//div[contains(@class, 'wFCpDb')]")
    private WebElement estimatedCostMessage;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[contains(normalize-space(), 'summary')]")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//style[contains(text(),'.SyW2Hf{--gm3-dialog-refactored-supporting-text-co')]")
    private WebElement styleDialog;

    @FindBy (xpath = "//div[@class='message-container ']//span[@class='close']")
    private WebElement closeQuestionMessageButton;

    private WebElement GPUModelBar;

    private WebElement GPUNumberBar;

    /**
     * Constructor for ComputeEnginePage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public ComputeEnginePage(WebDriver driver){
        super(driver);
        log.info("ComputeEnginePage initialized with driver.");
    }

    /**
     * Adds the specified number of instances to the form.
     *
     * @param instances The number of instances to add.
     */
    public void addInstances(String instances){
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).clear();
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).sendKeys(instances);
        log.info("Added instances: " + instances);
    }

    /**
     * Selects the specified operating system value.
     *
     * @param operatingSystem The operating system value to select.
     */
    public void selectOperatingSystemValue(String operatingSystem) {
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemBar)).click();
        WebElement operatingSystemSelected = getOptionToSelect(operatingSystem);
        operatingSystemSelected.click();
        log.info("Selected operating system: " + operatingSystem);
    }

    /**
     * Selects the "regular" provisioning model.
     * This method waits for the element to be clickable and handles ElementClickInterceptedException if encountered.
     */
    public void selectProvisioningModel_regular(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(provisioningModel_regularOption));
            provisioningModel_regularOption.click();
            log.info("Selected provisioning model: Regular");
        } catch (ElementClickInterceptedException e) {
            log.warn("ElementClickInterceptedException caught, retrying click on Regular button.");
            provisioningModel_regularOption.click();
            wait.until(ExpectedConditions.elementToBeClickable(provisioningModel_regularOption)).click();
            log.info("Selected provisioning model: Regular");
        }
    }

    /**
     * Selects the specified machine family.
     *
     * @param machineFamily The machine family to select.
     */
    public void selectMachineFamily(String machineFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(machineFamilyBar)).click();
        WebElement machineFamilySelected = getOptionToSelect(machineFamily);
        machineFamilySelected.click();
        log.info("Selected machine family: " + machineFamily);
    }

    /**
     * Selects the specified series.
     *
     * @param series The series to select.
     */
    public void selectSeries(String series) {
        wait.until(ExpectedConditions.elementToBeClickable(seriesBar)).click();
        WebElement seriesSelected = getOptionToSelect(series);
        seriesSelected.click();
        log.info("Selected series: " + series);
    }

    /**
     * Selects the specified machine type.
     *
     * @param machineType The machine type to select.
     */
    public void selectMachineType(String machineType) {
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeBar)).click();
        WebElement machineTypeSelected = getOptionToSelect(machineType);
        machineTypeSelected.click();
        log.info("Selected machine type: " + machineType);
    }

    /**
     * Activates the "add GPU" button.
     */
    public void addGPU_activateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUButton)).click();
        log.info("Activated 'Add GPU' button.");
    }

    /**
     * Selects the specified GPU model.
     *
     * @param GPUModel The GPU model to select.
     */
    public void addGPU_selectGPUModel(String GPUModel) {
        GPUModelBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(7);
        wait.until(ExpectedConditions.elementToBeClickable(GPUModelBar)).click();

        WebElement modelSelected = getOptionToSelect(GPUModel);
        modelSelected.click();
        log.info("Selected GPU model: " + GPUModel);
    }

    /**
     * Selects the GPU number.
     */
    public void addGPU_selectGPUNumber(String GPUNumber) {
        GPUNumberBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(8);
        wait.until(ExpectedConditions.elementToBeClickable(GPUNumberBar)).click();

        WebElement numberSelected = driver.findElement(By.xpath("//li[contains(@class, 'MCs1Pd') and .//span[normalize-space(text())='" + GPUNumber + "']]"));
        numberSelected.click();
        log.info("Selected GPU number.");
    }

    /**
     * Selects the specified local SSD option.
     *
     * @param localSSD The local SSD option to select.
     */
    public void selectLocalSSD(String localSSD) {
        wait.until(ExpectedConditions.elementToBeClickable(localSSDBar)).click();
        WebElement SSDSelected = getOptionToSelect(localSSD);
        wait.until(ExpectedConditions.visibilityOf(SSDSelected)).click();
        log.info("Selected local SSD: " + localSSD);
    }

    /**
     * Selects the specified data center location.
     *
     * @param dataCenterLocation The data center location to select.
     */
    public void selectDataCenterLocation(String dataCenterLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterLocationBar)).click();
        WebElement location = getOptionToSelect(dataCenterLocation);
        wait.until(ExpectedConditions.visibilityOf(location)).click();
        log.info("Selected data center location: " + dataCenterLocation);
    }

    /**
     * Selects the "one-year" committed use option.
     */
    public void selectCommittedUse_oneYear(){
        wait.until(ExpectedConditions.elementToBeClickable(committedUse_oneYearOption)).click();
        log.info("Selected committed use: One year.");
    }

    /**
     * Gets the estimated cost.
     *
     * @return True if the estimated cost message is displayed, otherwise false.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public Boolean getEstimatedCost() throws InterruptedException {
        log.info("Getting estimated cost.");
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOf(estimatedCostMessage)).isDisplayed();
    }

    /**
     * Closes the questions message box by clicking a clickable close button.
     */
    public void closeQuestionsMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(closeQuestionMessageButton));
        closeQuestionMessageButton.click();
    }

    /**
     * Clicks the share button to share the estimate.
     */
    public void submitShareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButton.click();
        log.info("Clicked share button.");
    }

    /**
     * Navigates to the Estimate Summary Page.
     *
     * @param tabTitle The title of the tab to switch to.
     */
    public void clickEstimateSummaryButton(String tabTitle) {
        log.info("Clicking Estimate Summary button");
        wait.until(ExpectedConditions.invisibilityOf(closeQuestionMessageButton));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(openEstimateSummaryButton));
            openEstimateSummaryButton.click();
        } catch (StaleElementReferenceException e) {
            log.warn("StaleElementReferenceException caught, retrying click on Estimate Summary button.");
            wait.until(ExpectedConditions.elementToBeClickable(openEstimateSummaryButton));
            openEstimateSummaryButton.click();
        }

        log.info("Switching to tab with title: " + tabTitle);
        changeToOtherTab(tabTitle);
    }

}
