package com.epam.training.jhony_soto.fundamental.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represents the Google Cloud Cost Estimate Summary page and provides methods to verify various elements on the page.
 */
public class CostEstimateSummaryPage extends AbstractPage {

    // Constants for field names
    private static final String FIELD_NUMBER_OF_INSTANCES = "Number of Instances";
    private static final String FIELD_OPERATING_SYSTEM = "Operating System / Software";
    private static final String FIELD_PROVISIONING_MODEL = "Provisioning Model";
    private static final String FIELD_MACHINE_TYPE = "Machine type";
    private static final String FIELD_GPU_MODEL = "GPU Model";
    private static final String FIELD_NUMBER_OF_GPUS = "Number of GPUs";
    private static final String FIELD_LOCAL_SSD = "Local SSD";
    private static final String FIELD_REGION = "Region";
    private static final String FIELD_COMMITTED_USE = "Committed use discount options";

    /**
     * Constructor for CostEstimateSummaryPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public CostEstimateSummaryPage(WebDriver driver) {
        super(driver);
        log.info("CostEstimateSummaryPage initialized with driver.");
    }

    /**
     * Gets the text value of a summary field based on the provided field name.
     *
     * @param fieldName The name of the field to retrieve the value for.
     * @return The text value of the specified field.
     */
    public String getSummaryFieldValue (String fieldName) {
        WebElement summaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[normalize-space(text())='" + fieldName + "']/following-sibling::span[@class='Kfvdz']")));
        return summaryField.getText();
    }

    /**
     * Verifies if the number of instances corresponds to the expected value.
     *
     * @param instances The expected number of instances.
     * @return True if the number of instances corresponds to the expected value, otherwise false.
     */
    public boolean isNumberOfInstancesCorresponding(String instances) {
        String actualValue = getSummaryFieldValue(FIELD_NUMBER_OF_INSTANCES);
        return actualValue.contains(instances);
    }

    /**
     * Verifies if the operating system corresponds to the expected value.
     *
     * @param operatingSystem The expected operating system.
     * @return True if the operating system corresponds to the expected value, otherwise false.
     */
    public boolean isOperatingSystemCorresponding(String operatingSystem) {
        String actualValue = getSummaryFieldValue(FIELD_OPERATING_SYSTEM);
        return actualValue.contains(operatingSystem);
    }

    /**
     * Verifies if the provisioning model corresponds to the expected value.
     *
     * @param provisioningModel The expected provisioning model.
     * @return True if the provisioning model corresponds to the expected value, otherwise false.
     */
    public boolean isProvisioningModelCorresponding(String provisioningModel) {
        String actualValue = getSummaryFieldValue(FIELD_PROVISIONING_MODEL);
        return actualValue.contains(provisioningModel);
    }

    /**
     * Verifies if the series corresponds to the expected value.
     *
     * @param series The expected series.
     * @return True if the series corresponds to the expected value, otherwise false.
     */
    public boolean isSeriesCorresponding(String series) {
        String actualValue = getSummaryFieldValue(FIELD_MACHINE_TYPE);
        return actualValue.contains(series.toLowerCase());
    }

    /**
     * Verifies if the machine type corresponds to the expected value.
     *
     * @param machineType The expected machine type.
     * @return True if the machine type corresponds to the expected value, otherwise false.
     */
    public boolean isMachineTypeCorresponding(String machineType) {
        String actualValue = getSummaryFieldValue(FIELD_MACHINE_TYPE);
        return actualValue.contains(machineType);
    }

    /**
     * Verifies if the GPU model corresponds to the expected value.
     *
     * @param GPUModel The expected GPU model.
     * @return True if the GPU model corresponds to the expected value, otherwise false.
     */
    public boolean isGPUModelCorresponding(String GPUModel) {
        String actualValue = getSummaryFieldValue(FIELD_GPU_MODEL);
        return actualValue.contains(GPUModel);
    }

    /**
     * Verifies if the number of GPUs corresponds to the expected value.
     *
     * @param GPUNumber The expected number of GPUs.
     * @return True if the number of GPUs corresponds to the expected value, otherwise false.
     */
    public boolean isGPUNumberCorresponding(String GPUNumber) {
        String actualValue = getSummaryFieldValue(FIELD_NUMBER_OF_GPUS);
        return actualValue.contains(GPUNumber);
    }

    /**
     * Verifies if the local SSD corresponds to the expected value.
     *
     * @param localSSD The expected local SSD.
     * @return True if the local SSD corresponds to the expected value, otherwise false.
     */
    public boolean isLocalSSDCorresponding(String localSSD) {
        String actualValue = getSummaryFieldValue(FIELD_LOCAL_SSD);
        return actualValue.contains(localSSD);
    }

    /**
     * Verifies if the data center location corresponds to the expected value.
     *
     * @param dataCenterLocation The expected data center location.
     * @return True if the data center location corresponds to the expected value, otherwise false.
     */
    public boolean isDataCenterLocationCorresponding(String dataCenterLocation) {
        String actualValue = getSummaryFieldValue(FIELD_REGION);
        return actualValue.contains(dataCenterLocation);
    }

    /**
     * Verifies if the committed usage corresponds to the expected value.
     *
     * @param committedUsage The expected committed usage.
     * @return True if the committed usage corresponds to the expected value, otherwise false.
     */
    public boolean isCommittedUsageCorresponding(String committedUsage) {
        String actualValue = getSummaryFieldValue(FIELD_COMMITTED_USE);
        return actualValue.contains(committedUsage);
    }

}
