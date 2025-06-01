package com.ygt.dashboard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.DTO.ProductionDTO;
import com.ygt.dashboard.Model.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {

    @Query("SELECT new com.ygt.dashboard.DTO.ProductionDTO( "+
       "p.productionId, p.productName, p.batchNumber, p.unitsProduced, p.defects, " +
       "p.qualityRate, p.inspector, p.status, p.cycleTime, p.productionRate, " +
       "p.machineEfficiency, p.targetRate, p.unitHour, p.defectRate, p.workingHour, p.productionDate, p.userId) " +
       "FROM Production p")
    List<ProductionDTO> getAllProductionDTOs();
}
