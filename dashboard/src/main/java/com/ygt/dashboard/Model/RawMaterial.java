package com.ygt.dashboard.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "raw_materials")
@Data
public class RawMaterial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialsId;

    @Column(name = "material_name")            
    private String materialsName;

    @Column(name = "monthly_expenses")
    private Integer monthlyExpenses;

    @Column(name = "last_order_date")
    private LocalDate lastOrderDate;
    
    @Column(name = "material_unit")
    private String materialUnit;

    @Column(name = "reorder_point")
    private Integer reorderPoint;

    @Column(name = "pending_orders")
    private Integer pendingOrders;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "material_status")
    private String materialStatus;

    @Column(name = "key_suppliers")
    private String keySuppliers;

    @Column(name = "total_material")
    private Double totalMaterial;

    @Column(name = "user_id")
    private Integer userId;
}

