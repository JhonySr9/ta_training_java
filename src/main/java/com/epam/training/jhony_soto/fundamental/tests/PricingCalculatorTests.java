package com.epam.training.jhony_soto.fundamental.tests;

import com.epam.training.jhony_soto.fundamental.model.PricingOrder;
import com.epam.training.jhony_soto.fundamental.pages.*;
import com.epam.training.jhony_soto.fundamental.services.CreatePricingOrder;
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
    @Test (groups = {"smoke"}, invocationCount = 1)
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

        // 6. Verify the estimated cost.
        assertTrue(computeEnginePage.getEstimatedCost());

        // 7. Share the estimate and navigate to the summary page.
        computeEnginePage.submitShareButton();
        computeEnginePage.clickEstimateSummaryButton(SUMMARY_TAB_NAME);

        // 8. Verify the values on the summary page corresponds to the data used to fill the form.
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

    /**
     * Testing of the Pricing Calculator functionality.
     * @throws InterruptedException error in case a value is not displayed after a wait.
     */
    @Test (groups = {"smoke"}, invocationCount = 1)
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

        // 6. Verify the estimated cost is not there, which will activate the Screenshot for failure.
        assertFalse(computeEnginePage.getEstimatedCost());
    }
}
