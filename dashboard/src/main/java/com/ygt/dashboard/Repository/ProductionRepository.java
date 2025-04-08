package com.ygt.dashboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.Model.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {

    
}
