package com.epam.training.jhony_soto.fundamental.services;

import com.epam.training.jhony_soto.fundamental.model.PricingOrder;

public class CreatePricingOrder {
    // Use "environment.properties" file from Resources package file set data.
    public static final String INSTANCES = "testdata.pricingOrder.instances";
    public static final String OPERATING_SYSTEM = "testdata.pricingOrder.operatingSystem";
    public static final String MACHINE_FAMILY = "testdata.pricingOrder.machineFamily";
    public static final String SERIES = "testdata.pricingOrder.series";
    public static final String MACHINE_TYPE = "testdata.pricingOrder.machineType";
    public static final String ADD_GPU_GPU_MODEL = "testdata.pricingOrder.addGPU_GPUModel";
    public static final String ADD_GPU_GPU_NUMBER = "testdata.pricingOrder.addGPU_GPUNumber";
    public static final String SSD = "testdata.pricingOrder.SSD";
    public static final String DATA_CENTER_LOCATION = "testdata.pricingOrder.dataCenterLocation";

    public static PricingOrder withAllData() {
        return new PricingOrder(
                TestDataReader.getTestData(INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_FAMILY),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(ADD_GPU_GPU_MODEL),
                TestDataReader.getTestData(ADD_GPU_GPU_NUMBER),
                TestDataReader.getTestData(SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION));
    }
}
