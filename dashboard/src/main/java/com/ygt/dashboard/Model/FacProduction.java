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
@Table(name = "facproduction")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacProduction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Long productionId;

    @Column(name = "user_id")
    private Long userId;

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

    @Column(name = "inspector")
    private String inspector;

    @Column(name = "status")
    private String status;

    @Column(name = "cycle_time")
    private Double cycleTime;

    @Column(name = "production_rate")
    private Double productionRate;

    @Column(name = "target_rate")
    private Double targetRate;

    @Column(name = "unitproduced_hour")
    private Double unitproducedHour;

    @Column(name = "defect_rate")
    private Double defectRate;

    @Column(name = "up_time")
    private Double upTime;

    @Column(name = "production_date")
    private LocalDate productionDate;
}
