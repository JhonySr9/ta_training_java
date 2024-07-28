package com.epam.training.jhony_soto.fundamental.tests;

import com.epam.training.jhony_soto.fundamental.model.PricingOrder;
import com.epam.training.jhony_soto.fundamental.pages.*;
import com.epam.training.jhony_soto.fundamental.services.CreatePricingOrder;
import com.epam.training.jhony_soto.fundamental.util.Retry;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * This class contains test cases for Google Cloud Pricing Calculator.
 */

public class PricingCalculatorTests extends BaseTests {

    /**
     * Testing of the Pricing Calculator functionality.
     * @throws InterruptedException error in case a value is not displayed after a wait.
     */
    @Test (groups = {"smoke"}, invocationCount = 2, retryAnalyzer = Retry.class)
    public void usePricingCalculatorTest() throws InterruptedException {
        ////// Data //////
        PricingOrder order = CreatePricingOrder.withAllData();

        ////// Test //////
        // 1. Navigate to the home page.
        goToURL(HOMEPAGE_URL);

        // 2. Search for the pricing calculator.
        var googleCloud_homePage = new HomePage(driver);
        googleCloud_homePage.useSearchBar(PRICING_CALCULATOR_SEARCH_VALUE);

        // 3. Select the search result.
        var resultsPage =  new ResultsPage(driver);
        resultsPage.selectSearchResult(PRICING_CALCULATOR_SEARCH_VALUE);

        //4. Navigate to the pricing calculator page.
        var pricingCalculatorPage =  new PricingCalculatorPage(driver);
        pricingCalculatorPage.pressAddAnEstimateButton();
        pricingCalculatorPage.openComputeEnginePage();

        // 5. Fill in the form on the Compute Engine page.
        var computeEnginePage = new ComputeEnginePage(driver);
        computeEnginePage.addGPU_activateButton();
        computeEnginePage.addInstances(order.getInstances());
        computeEnginePage.selectOperatingSystemValue(order.getOperatingSystem());
        computeEnginePage.selectProvisioningModel_regular();
        computeEnginePage.selectMachineFamily(order.getMachineFamily());
        computeEnginePage.selectSeries(order.getSeries());
        computeEnginePage.selectMachineType(order.getMachineType());
        computeEnginePage.addGPU_selectGPUModel(order.getAddGPU_GPUModel());
        computeEnginePage.addGPU_selectGPUNumber(order.getAddGPU_GPUNumber());
        computeEnginePage.selectLocalSSD(order.getSSD());
        computeEnginePage.selectDataCenterLocation(order.getDataCenterLocation());
        computeEnginePage.selectCommittedUse_oneYear();

        // 6. Close the Question Message Box.
        computeEnginePage.closeQuestionsMessage();

        // 7. Verify the estimated cost.
        assertTrue(computeEnginePage.getEstimatedCost());
        log.info("Verified that the estimated cost was retrieved successfully.");

        // 8. Share the estimate and navigate to the summary page.
        computeEnginePage.submitShareButton();
        computeEnginePage.clickEstimateSummaryButton(SUMMARY_TAB_NAME);

        // 9. Verify the values on the summary page corresponds to the data used to fill the form.
        var costEstimateSummaryPage = new CostEstimateSummaryPage(driver);
        assertTrue(costEstimateSummaryPage.isNumberOfInstancesCorresponding(order.getInstances()));
        log.info("Verified that the number of instances corresponds to: " + order.getInstances());

        assertTrue(costEstimateSummaryPage.isOperatingSystemCorresponding(order.getOperatingSystem()));
        log.info("Verified that the operating system corresponds to: " + order.getOperatingSystem());

        assertTrue(costEstimateSummaryPage.isProvisioningModelCorresponding(PROVISIONING_MODEL_REGULAR_OPTION));
        log.info("Verified that the provisioning model corresponds to: " + PROVISIONING_MODEL_REGULAR_OPTION);

        assertTrue(costEstimateSummaryPage.isSeriesCorresponding(order.getSeries()));
        log.info("Verified that the series corresponds to: " + order.getSeries());

        assertTrue(costEstimateSummaryPage.isMachineTypeCorresponding(order.getMachineType()));
        log.info("Verified that the machine type corresponds to: " + order.getMachineType());

        assertTrue(costEstimateSummaryPage.isGPUModelCorresponding(order.getAddGPU_GPUModel()));
        log.info("Verified that the GPU model corresponds to: " + order.getAddGPU_GPUModel());

        assertTrue(costEstimateSummaryPage.isGPUNumberCorresponding(order.getAddGPU_GPUNumber()));
        log.info("Verified that the GPU number corresponds to: " + order.getAddGPU_GPUNumber());

        assertTrue(costEstimateSummaryPage.isLocalSSDCorresponding(order.getSSD()));
        log.info("Verified that the local SSD corresponds to: " + order.getSSD());

        assertTrue(costEstimateSummaryPage.isDataCenterLocationCorresponding(order.getDataCenterLocation()));
        log.info("Verified that the data center location corresponds to: " + order.getDataCenterLocation());

        assertTrue(costEstimateSummaryPage.isCommittedUsageCorresponding(COMMITTED_USAGE_1YEAR_OPTION));
        log.info("Verified that the committed usage corresponds to: " + COMMITTED_USAGE_1YEAR_OPTION);
    }

    /**
     * Testing of the Pricing Calculator functionality.
     * @throws InterruptedException error in case a value is not displayed after a wait.
     */
    @Test (groups = {"failed"})
    public void failedUsePricingCalculatorTest() throws InterruptedException {
        ////// Data //////
        PricingOrder order = CreatePricingOrder.withAllData();

        ////// Test //////
        // 1. Navigate to the home page.
        goToURL(HOMEPAGE_URL);

        // 2. Search for the pricing calculator.
        var googleCloud_homePage = new HomePage(driver);
        googleCloud_homePage.useSearchBar(PRICING_CALCULATOR_SEARCH_VALUE);

        // 3. Select the search result.
        var resultsPage =  new ResultsPage(driver);
        resultsPage.selectSearchResult(PRICING_CALCULATOR_SEARCH_VALUE);

        //4. Navigate to the pricing calculator page.
        var pricingCalculatorPage =  new PricingCalculatorPage(driver);
        pricingCalculatorPage.pressAddAnEstimateButton();
        pricingCalculatorPage.openComputeEnginePage();

        // 5. Fill in the form on the Compute Engine page.
        var computeEnginePage = new ComputeEnginePage(driver);
        computeEnginePage.addGPU_activateButton();
        computeEnginePage.addInstances(order.getInstances());
        computeEnginePage.selectOperatingSystemValue(order.getOperatingSystem());
        computeEnginePage.selectProvisioningModel_regular();
        computeEnginePage.selectMachineFamily(order.getMachineFamily());
        computeEnginePage.selectSeries(order.getSeries());
        computeEnginePage.selectMachineType(order.getMachineType());
        computeEnginePage.addGPU_selectGPUModel(order.getAddGPU_GPUModel());
        computeEnginePage.addGPU_selectGPUNumber(order.getAddGPU_GPUNumber());
        computeEnginePage.selectLocalSSD(order.getSSD());
        computeEnginePage.selectDataCenterLocation(order.getDataCenterLocation());
        computeEnginePage.selectCommittedUse_oneYear();

        // 6. Close the Question Message Box.
        computeEnginePage.closeQuestionsMessage();
        log.info("Verified that the estimated cost was retrieved successfully.");

        // 7. Verify the estimated cost is not there, which will activate the Screenshot for failure.
        assertFalse(computeEnginePage.getEstimatedCost());
        log.info("Verified that the estimated cost is not present, triggering screenshot for failure.");
    }
}
