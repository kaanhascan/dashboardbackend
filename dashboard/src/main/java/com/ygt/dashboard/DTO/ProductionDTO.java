package com.ygt.dashboard.DTO;

import java.time.LocalDate;

public class ProductionDTO {
    private Long productionId;
    private String productName;
    private String batchNumber;
    private int unitsProduced;
    private int defects;
    private double qualityRate;
    private String inspector;
    private String status;
    private double cycleTime;
    private double productionRate;
    private double machineEfficiency;
    private double targetRate;
    private double unitHour;
    private double defectRate;
    private double workingHour;
    private LocalDate productionDate;
    private Long userId;


    public ProductionDTO() {}

    public ProductionDTO(Long productionId, String productName, String batchNumber, Integer unitsProduced, Integer defects,
                        Double qualityRate, String inspector, String status, Double cycleTime, Double productionRate,
                        Double machineEfficiency, Double targetRate, Double unitHour, Double defectRate,
                        Double workingHour, LocalDate productionDate, Long userId) {
        this.productionId = productionId;
        this.productName = productName;
        this.batchNumber = batchNumber;
        this.unitsProduced = unitsProduced != null ? unitsProduced : 0;
        this.defects = defects != null ? defects : 0;
        this.qualityRate = qualityRate != null ? qualityRate : 0.0;
        this.inspector = inspector;
        this.status = status;
        this.cycleTime = cycleTime != null ? cycleTime : 0.0;
        this.productionRate = productionRate != null ? productionRate : 0.0;
        this.machineEfficiency = machineEfficiency != null ? machineEfficiency : 0.0;
        this.targetRate = targetRate != null ? targetRate : 0.0;
        this.unitHour = unitHour != null ? unitHour : 0.0;
        this.defectRate = defectRate != null ? defectRate : 0.0;
        this.workingHour = workingHour != null ? workingHour : 0.0;
        this.productionDate = productionDate;
        this.userId = userId;
    }

    
    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getUnitsProduced() {
        return unitsProduced;
    }


    public void setUnitsProduced(int unitsProduced) {
        this.unitsProduced = unitsProduced;
    }

    public int getDefects() {
        return defects;
    }

    public void setDefects(int defects) {
        this.defects = defects;
    }

    public double getQualityRate() {
        return qualityRate;
    }

    public void setQualityRate(double qualityRate) {
        this.qualityRate = qualityRate;
    }

    public String getInspector() {  
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public double getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(double productionRate) {
        this.productionRate = productionRate;
    }

    public double getMachineEfficiency() {
        return machineEfficiency;
    }

    public void setMachineEfficiency(double machineEfficiency) {
        this.machineEfficiency = machineEfficiency;
    }

    public double getTargetRate() {
        return targetRate;
    }

    public void setTargetRate(double targetRate) {
        this.targetRate = targetRate;
    }

    public double getUnitHour() {
        return unitHour;
    }

    public void setUnitHour(double unitHour) {
        this.unitHour = unitHour;
    }

    public double getDefectRate() {
        return defectRate;
    }

    public void setDefectRate(double defectRate) {
        this.defectRate = defectRate;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(double workingHour) {
        this.workingHour = workingHour;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
