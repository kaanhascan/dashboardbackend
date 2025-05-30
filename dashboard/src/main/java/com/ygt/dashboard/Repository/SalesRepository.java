package com.ygt.dashboard.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.DTO.SalesDTO;
import com.ygt.dashboard.Model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {
    @Query("SELECT new com.ygt.dashboard.DTO.SalesDTO(" +
       "s.productId, s.productName, s.totalOrders, s.productSold, s.revenue, " +
       "s.newCustomers, s.unitsSold, s.status, s.topCustomers, s.salesDate, " +
       "s.unitPrice, s.salesAddress, s.userId) " +
       "FROM Sales s")
    List<SalesDTO> getAllSalesDTOs();
}