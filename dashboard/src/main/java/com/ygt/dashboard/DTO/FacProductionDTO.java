package com.ygt.dashboard.DTO;

import java.time.LocalDate;

public class FacProductionDTO {
    private Long productionId;
    private Long userId;
    private String productName;
    private String batchNumber;
    private int unitsProduced;
    private int defects;
    private double qualityRate;
    private String inspector;
    private String status;
    private double cycleTime;
    private double productionRate;
    private double targetRate;
    private double unitproducedHour;
    private double defectRate;
    private double upTime;
    private LocalDate productionDate;

    public FacProductionDTO() {}

    public FacProductionDTO(Long productionId, Long userId, String productName, String batchNumber, Integer unitsProduced, Integer defects,
                        Double qualityRate, String inspector, String status, Double cycleTime, Double productionRate,
                        Double targetRate, Double unitproducedHour, Double defectRate, Double upTime, LocalDate productionDate) {
        this.productionId = productionId;
        this.userId = userId;
        this.productName = productName;
        this.batchNumber = batchNumber;
        this.unitsProduced = unitsProduced != null ? unitsProduced : 0;
        this.defects = defects != null ? defects : 0;
        this.qualityRate = qualityRate != null ? qualityRate : 0.0;
        this.inspector = inspector;
        this.status = status;
        this.cycleTime = cycleTime != null ? cycleTime : 0.0;
        this.productionRate = productionRate != null ? productionRate : 0.0;
        this.targetRate = targetRate != null ? targetRate : 0.0;
        this.unitproducedHour = unitproducedHour != null ? unitproducedHour : 0.0;
        this.defectRate = defectRate != null ? defectRate : 0.0;
        this.upTime = upTime != null ? upTime : 0.0;
        this.productionDate = productionDate;
    }

    public Long getProductionId() { return productionId; }
    public void setProductionId(Long productionId) { this.productionId = productionId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }
    public int getUnitsProduced() { return unitsProduced; }
    public void setUnitsProduced(int unitsProduced) { this.unitsProduced = unitsProduced; }
    public int getDefects() { return defects; }
    public void setDefects(int defects) { this.defects = defects; }
    public double getQualityRate() { return qualityRate; }
    public void setQualityRate(double qualityRate) { this.qualityRate = qualityRate; }
    public String getInspector() { return inspector; }
    public void setInspector(String inspector) { this.inspector = inspector; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getCycleTime() { return cycleTime; }
    public void setCycleTime(double cycleTime) { this.cycleTime = cycleTime; }
    public double getProductionRate() { return productionRate; }
    public void setProductionRate(double productionRate) { this.productionRate = productionRate; }
    public double getTargetRate() { return targetRate; }
    public void setTargetRate(double targetRate) { this.targetRate = targetRate; }
    public double getUnitproducedHour() { return unitproducedHour; }
    public void setUnitproducedHour(double unitproducedHour) { this.unitproducedHour = unitproducedHour; }
    public double getDefectRate() { return defectRate; }
    public void setDefectRate(double defectRate) { this.defectRate = defectRate; }
    public double getUpTime() { return upTime; }
    public void setUpTime(double upTime) { this.upTime = upTime; }
    public LocalDate getProductionDate() { return productionDate; }
    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }
}
