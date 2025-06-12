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
@Table(name = "commodity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comm_id")
    private Long commId;

    @Column(name = "comm_name")            
    private String commName;

    @Column(name = "monthly_expenses")
    private Integer monthlyExpenses;

    @Column(name = "last_ordered")
    private LocalDate lastOrdered;
    
    @Column(name = "unit")
    private String unit;

    @Column(name = "restock_point")
    private Integer restockPoint;

    @Column(name = "pending_order")
    private Integer pendingOrder;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "status")
    private String status;

    @Column(name = "suppliers")
    private String suppliers;

    @Column(name = "total_commodity")
    private Double totalCommodity;

    @Column(name = "user_id")
    private Long userId;
}

