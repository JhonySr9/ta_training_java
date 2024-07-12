package com.epam.training.jhony_soto.fundamental.tests;

import com.epam.training.jhony_soto.fundamental.model.PricingOrder;
import com.epam.training.jhony_soto.fundamental.pages.*;
import com.epam.training.jhony_soto.fundamental.services.CreatePricingOrder;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * This class contains test cases for Google Cloud Pricing Calculator.
 */

public class PricingCalculatorTests extends BaseTests {

    /**
     * Testing of the Pricing Calculator functionality.
     * @throws InterruptedException error in case a value is not displayed after a wait.
     */
    @Test (groups = {"smoke"}, invocationCount = 1)
    public void usePricingCalculatorTest() throws InterruptedException {
        ////// Data //////
        PricingOrder order = CreatePricingOrder.withAllData();

        ////// Test //////
        // Navigate to the home page
        goToURL(HOMEPAGE_URL);

        // Instantiate the home page and search for the pricing calculator
        var googleCloud_homePage = new HomePage(driver);
        googleCloud_homePage.useSearchBar(PRICING_CALCULATOR_SEARCH_VALUE);

        var resultsPage =  new ResultsPage(driver);
        resultsPage.selectSearchResult(PRICING_CALCULATOR_SEARCH_VALUE);

        // Select the search result and navigate to the pricing calculator page
        var pricingCalculatorPage =  new PricingCalculatorPage(driver);
        pricingCalculatorPage.pressAddAnEstimateButton();
        pricingCalculatorPage.openComputeEnginePage();

        // Fill in the form on the Compute Engine page
        var computeEnginePage = new ComputeEnginePage(driver);
        computeEnginePage.addGPU_activateButton();
        computeEnginePage.addInstances(order.getInstances());
        computeEnginePage.selectOperatingSystemValue(order.getOperatingSystem());
        computeEnginePage.selectProvisioningModel_regular();
        computeEnginePage.selectMachineFamily(order.getMachineFamily());
        computeEnginePage.selectSeries(order.getSeries());
        computeEnginePage.selectMachineType(order.getMachineType());
        computeEnginePage.addGPU_selectGPUModel(order.getAddGPU_GPUModel());
        computeEnginePage.addGPU_selectGPUNumber();
        computeEnginePage.selectLocalSSD(order.getSSD());
        computeEnginePage.selectDataCenterLocation(order.getDataCenterLocation());
        computeEnginePage.selectCommittedUse_oneYear();

        // Verify the estimated cost
        assertTrue(computeEnginePage.getEstimatedCost());

        // Share the estimate and navigate to the summary page
        computeEnginePage.submitShareButton();
        computeEnginePage.clickEstimateSummaryButton(SUMMARY_TAB_NAME);

        //////Assertions//////
        // Assertions to verify the values on the summary page
        var costEstimateSummaryPage = new CostEstimateSummaryPage(driver);
        assertTrue(costEstimateSummaryPage.numberOfInstancesCorresponds(order.getInstances()));
        assertTrue(costEstimateSummaryPage.operatingSystemCorresponds(order.getOperatingSystem()));
        assertTrue(costEstimateSummaryPage.provisioningModelCorresponds(PROVISIONING_MODEL_REGULAR_OPTION));
        assertTrue(costEstimateSummaryPage.seriesCorresponds(order.getSeries()));
        assertTrue(costEstimateSummaryPage.machineTypeCorresponds(order.getMachineType()));
        assertTrue(costEstimateSummaryPage.GPUModelCorresponds(order.getAddGPU_GPUModel()));
        assertTrue(costEstimateSummaryPage.GPUNumberCorresponds(order.getAddGPU_GPUNumber()));
        assertTrue(costEstimateSummaryPage.localSSDCorresponds(order.getSSD()));
        assertTrue(costEstimateSummaryPage.dataCenterLocationCorresponds(order.getDataCenterLocation()));
        assertTrue(costEstimateSummaryPage.committedUsageCorresponds(COMMITTED_USAGE_1YEAR_OPTION));
    }
}
