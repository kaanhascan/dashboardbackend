package com.ygt.dashboard.DTO;

import java.time.LocalDate;

public class RawMaterialDTO {
    private Long materialsId;
    private String materialsName;
    private Integer monthlyExpenses;
    private LocalDate lastOrderDate;
    private String materialUnit;
    private Integer reorderPoint;
    private Integer pendingOrders;
    private Integer currentStock;
    private String materialStatus;
    private String keySuppliers;
    private Double totalMaterial;
    private Long userId;


    public RawMaterialDTO() {
    }


    public RawMaterialDTO(Long materialsId, String materialsName, Integer monthlyExpenses, LocalDate lastOrderDate,
                         String materialUnit, Integer reorderPoint, Integer pendingOrders, Integer currentStock,
                         String materialStatus, String keySuppliers, Double totalMaterial, Long userId) {
        this.materialsId = materialsId;
        this.materialsName = materialsName;
        this.monthlyExpenses = monthlyExpenses;
        this.lastOrderDate = lastOrderDate;
        this.materialUnit = materialUnit;
        this.reorderPoint = reorderPoint;
        this.pendingOrders = pendingOrders;
        this.currentStock = currentStock;
        this.materialStatus = materialStatus;
        this.keySuppliers = keySuppliers;
        this.totalMaterial = totalMaterial;
        this.userId = userId;
    }

    public Long getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Long materialsId) {
        this.materialsId = materialsId;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public Integer getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(Integer monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public LocalDate getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(LocalDate lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public Integer getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(Integer reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public Integer getPendingOrders() {
        return pendingOrders;
    }

    public void setPendingOrders(Integer pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public String getMaterialStatus() {
        return materialStatus;
    }

    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    public String getKeySuppliers() {
        return keySuppliers;
    }

    public void setKeySuppliers(String keySuppliers) {
        this.keySuppliers = keySuppliers;
    }

    public Double getTotalMaterial() {
        return totalMaterial;
    }

    public void setTotalMaterial(Double totalMaterial) {
        this.totalMaterial = totalMaterial;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
