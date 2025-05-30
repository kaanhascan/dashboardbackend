package com.ygt.dashboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.Model.RawMaterial;
import com.ygt.dashboard.DTO.RawMaterialDTO;

import java.util.List;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    @Query("SELECT new com.ygt.dashboard.DTO.RawMaterialDTO(" +
           "r.materialsId, r.materialsName, r.monthlyExpenses, r.lastOrderDate, " +
           "r.materialUnit, r.reorderPoint, r.pendingOrders, r.currentStock, " +
           "r.materialStatus, r.keySuppliers, r.totalMaterial, r.userId) " +
           "FROM RawMaterial r")
    List<RawMaterialDTO> getAllRawMaterialDTOs();
}