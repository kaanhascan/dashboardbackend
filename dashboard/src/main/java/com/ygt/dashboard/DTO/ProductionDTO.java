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


    public ProductionDTO() {
    }

    public ProductionDTO(Long productionId, String productName, String batchNumber, Integer unitsProduced, Integer defects,
                        Double qualityRate, String inspector, String status, Double cycleTime, Double productionRate,
                        Double machineEfficiency, Double targetRate, Double unitHour, Double defectRate,
                        Double workingHour, LocalDate productionDate) {
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
    }

    // Existing getters remain the same
    public Long getProductionId() {
        return productionId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public int getUnitsProduced() {
        return unitsProduced;
    }

    public int getDefects() {
        return defects;
    }

    public double getQualityRate() {
        return qualityRate;
    }

    public String getInspector() {
        return inspector;
    }

    public String getStatus() {
        return status;
    }

    public double getCycleTime() {
        return cycleTime;
    }

    public double getProductionRate() {
        return productionRate;
    }

    public double getMachineEfficiency() {
        return machineEfficiency;
    }

    public double getTargetRate() {
        return targetRate;
    }

    public double getUnitHour() {
        return unitHour;
    }

    public double getDefectRate() {
        return defectRate;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }
}
