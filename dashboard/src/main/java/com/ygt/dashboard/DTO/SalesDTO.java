package com.ygt.dashboard.DTO;

import java.time.LocalDate;

public class SalesDTO {
    private Long productId;
    private String productName;
    private Integer totalOrders;
    private Integer productSold;
    private Double revenue;
    private Integer newCustomers;
    private Integer unitsSold;
    private String status;
    private String topCustomers;
    private LocalDate salesDate;
    private Integer unitPrice;
    private String salesAddress;
    private Long userId;


    public SalesDTO() {
    }


    public SalesDTO(Long productId, String productName, Integer totalOrders, Integer productSold, Double revenue,
                    Integer newCustomers, Integer unitsSold, String status, String topCustomers, LocalDate salesDate,
                    Integer unitPrice, String salesAddress, Long userId) {
        this.productId = productId;
        this.productName = productName;
        this.totalOrders = totalOrders;
        this.productSold = productSold;
        this.revenue = revenue;
        this.newCustomers = newCustomers;
        this.unitsSold = unitsSold;
        this.status = status;
        this.topCustomers = topCustomers;
        this.salesDate = salesDate;
        this.unitPrice = unitPrice;
        this.salesAddress = salesAddress;
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Integer getProductSold() {
        return productSold;
    }

    public void setProductSold(Integer productSold) {
        this.productSold = productSold;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Integer getNewCustomers() {
        return newCustomers;
    }

    public void setNewCustomers(Integer newCustomers) {
        this.newCustomers = newCustomers;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTopCustomers() {
        return topCustomers;
    }

    public void setTopCustomers(String topCustomers) {
        this.topCustomers = topCustomers;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSalesAddress() {
        return salesAddress;
    }

    public void setSalesAddress(String salesAddress) {
        this.salesAddress = salesAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
