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
@Table(name = "production")
@Data
public class Production {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Long productionId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "units_produced")
    private Integer unitsProduced;

    @Column(name = "defects")
    private Integer defects;

    @Column(name = "quality_rate")
    private Double qualityRate;

    @Column(name = "ınsptector") //bu doğru mu aq
    private String inspector;

    @Column(name = "status")
    private String status;

    @Column(name = "cycle_time")
    private Double cycleTime;

    @Column(name = "production_rate")
    private Double productionRate;

    @Column(name = "machine_efficiency")
    private Double machineEfficiency;

    @Column(name = "target_rate")
    private Double targetRate;

    @Column(name = "unit_hour")
    private Double unitHour;

    @Column(name = "defect_rate")
    private Double defectRate;

    @Column(name = "working_hour")
    private Double workingHour;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "user_id")
    private Long id;
}
