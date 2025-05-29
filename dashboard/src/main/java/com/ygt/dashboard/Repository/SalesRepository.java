package com.ygt.dashboard.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ygt.dashboard.Model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {
    
}