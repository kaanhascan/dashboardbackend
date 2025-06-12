package com.ygt.dashboard.DTO;

import java.time.LocalDate;

public class CommodityDTO {
    private Long commId;
    private String commName;
    private Integer monthlyExpenses;
    private LocalDate lastOrdered;
    private String unit;
    private Integer restockPoint;
    private Integer pendingOrder;
    private Integer currentStock;
    private String status;
    private String suppliers;
    private Double totalCommodity;
    private Long userId;

    public CommodityDTO() {}

    public CommodityDTO(Long commId, String commName, Integer monthlyExpenses, LocalDate lastOrdered,
                        String unit, Integer restockPoint, Integer pendingOrder, Integer currentStock,
                        String status, String suppliers, Double totalCommodity, Long userId) {
        this.commId = commId;
        this.commName = commName;
        this.monthlyExpenses = monthlyExpenses;
        this.lastOrdered = lastOrdered;
        this.unit = unit;
        this.restockPoint = restockPoint;
        this.pendingOrder = pendingOrder;
        this.currentStock = currentStock;
        this.status = status;
        this.suppliers = suppliers;
        this.totalCommodity = totalCommodity;
        this.userId = userId;
    }

    public Long getCommId() { return commId; }
    public void setCommId(Long commId) { this.commId = commId; }
    public String getCommName() { return commName; }
    public void setCommName(String commName) { this.commName = commName; }
    public Integer getMonthlyExpenses() { return monthlyExpenses; }
    public void setMonthlyExpenses(Integer monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }
    public LocalDate getLastOrdered() { return lastOrdered; }
    public void setLastOrdered(LocalDate lastOrdered) { this.lastOrdered = lastOrdered; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public Integer getRestockPoint() { return restockPoint; }
    public void setRestockPoint(Integer restockPoint) { this.restockPoint = restockPoint; }
    public Integer getPendingOrder() { return pendingOrder; }
    public void setPendingOrder(Integer pendingOrder) { this.pendingOrder = pendingOrder; }
    public Integer getCurrentStock() { return currentStock; }
    public void setCurrentStock(Integer currentStock) { this.currentStock = currentStock; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSuppliers() { return suppliers; }
    public void setSuppliers(String suppliers) { this.suppliers = suppliers; }
    public Double getTotalCommodity() { return totalCommodity; }
    public void setTotalCommodity(Double totalCommodity) { this.totalCommodity = totalCommodity; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
