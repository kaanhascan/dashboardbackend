package com.ygt.dashboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ygt.dashboard.Model.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long>{
    
}
