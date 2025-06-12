package com.ygt.dashboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.Model.Commodity;
import com.ygt.dashboard.DTO.CommodityDTO;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {

    @Query("SELECT new com.ygt.dashboard.DTO.CommodityDTO(" +
           "c.commId, c.commName, c.monthlyExpenses, c.lastOrdered, " +
           "c.unit, c.restockPoint, c.pendingOrder, c.currentStock, " +
           "c.status, c.suppliers, c.totalCommodity, c.userId) " +
           "FROM Commodity c")
    List<CommodityDTO> getAllCommodityDTOs();
}