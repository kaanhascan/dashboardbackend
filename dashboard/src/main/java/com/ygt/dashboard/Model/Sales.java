package com.ygt.dashboard.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")      
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "total_orders")
    private Integer totalOrders;

    @Column(name = "product_solds")
    private Integer productSold;

    @Column(name = "revenue")
    private Double revenue;

    @Column(name = "new_customers")
    private Integer newCustomers;

    @Column(name = "units_sold")
    private Integer unitsSold;

    @Column(name = "status")
    private String status;  

    @Column(name = "top_customers")
    private String topCustomers;

    @Column(name = "sales_date")
    private LocalDate salesDate;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "sales_address")
    private String salesAddress;

    @Column(name = "user_id")
    private Long userId;
}
