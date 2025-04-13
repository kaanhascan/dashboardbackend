package com.ygt.dashboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ygt.dashboard.Model.Sales;;
public interface SalesRepository extends JpaRepository<Sales,Long> {
    
}