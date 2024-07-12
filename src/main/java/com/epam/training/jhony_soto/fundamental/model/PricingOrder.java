package com.epam.training.jhony_soto.fundamental.model;

import java.util.Objects;

public class PricingOrder {

    private String instances;
    private String operatingSystem;
    private String machineFamily;
    private String series;
    private String machineType;
    private String addGPU_GPUModel;
    private String addGPU_GPUNumber;
    private String SSD;
    private String dataCenterLocation;

    /**
     * Constructor to initialize all fields.
     */
    public PricingOrder(String instances, String operatingSystem, String machineFamily, String series,
                        String machineType, String addGPU_GPUModel, String addGPU_GPUNumber, String SSD,
                        String dataCenterLocation){
        this.instances = instances;
        this.operatingSystem = operatingSystem;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.addGPU_GPUModel = addGPU_GPUModel;
        this.addGPU_GPUNumber = addGPU_GPUNumber;
        this.SSD = SSD;
        this.dataCenterLocation = dataCenterLocation;
    }

     //Getters and Setters

    public String getInstances() {
        return instances;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getAddGPU_GPUModel() {
        return addGPU_GPUModel;
    }

    public void setAddGPU_GPUModel(String addGPU_GPUModel) {
        this.addGPU_GPUModel = addGPU_GPUModel;
    }

    public String getAddGPU_GPUNumber() {
        return addGPU_GPUNumber;
    }

    public void setAddGPU_GPUNumber(String addGPU_GPUNumber) {
        this.addGPU_GPUNumber = addGPU_GPUNumber;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String SSD) {
        this.SSD = SSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    /**
     * Returns a string representation of the PricingOrder object.
     *
     * @return A string representation of the PricingOrder object, including all its fields.
     */
    @Override
    public String toString() {
        return "PricingOrder{" +
                ", instances='" + instances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPU_GPUModel='" + addGPU_GPUModel + '\'' +
                ", addGPU_GPUNumber='" + addGPU_GPUNumber + '\'' +
                ", SSD='" + SSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * This method compares the PricingOrder object to another object to check if they are equal.
     *
     * @param o The object to compare this PricingOrder against.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingOrder that = (PricingOrder) o;
        return  Objects.equals(instances, that.instances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineFamily, that.machineFamily) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(addGPU_GPUModel, that.addGPU_GPUModel) &&
                Objects.equals(addGPU_GPUNumber, that.addGPU_GPUNumber) &&
                Objects.equals(SSD, that.SSD) &&
                Objects.equals(dataCenterLocation, that.dataCenterLocation);
    }

    /**
     * Returns a hash code value for the PricingOrder object.
     * This method generates a hash code based on the fields of the PricingOrder object.
     *
     * @return A hash code value for this PricingOrder object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(instances, operatingSystem, machineFamily, series,
                machineType, addGPU_GPUModel, addGPU_GPUNumber, SSD, dataCenterLocation);
    }

}
