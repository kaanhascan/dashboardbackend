package com.ygt.dashboard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.Model.FacProduction;

@Repository
public interface FacProductionRepository extends JpaRepository<FacProduction, Long> {
    @Query("SELECT new com.ygt.dashboard.DTO.FacProductionDTO(" +
       "f.productionId, f.userId, f.productName, f.batchNumber, f.unitsProduced, f.defects, " +
       "f.qualityRate, f.inspector, f.status, f.cycleTime, f.productionRate, " +
       "f.targetRate, f.unitproducedHour, f.defectRate, f.upTime, f.productionDate) " +
       "FROM FacProduction f")
    List<FacProductionDTO> getAllFacProductionDTOs();
}
