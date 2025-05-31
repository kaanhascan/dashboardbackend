package com.ygt.dashboard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.Service.PerformanceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/production-fetch")
    public ResponseEntity<PerformanceResultDTO> getProductionFetchPerformance() {
        return ResponseEntity.ok(performanceService.measureProductionFetch());
    }

    @GetMapping("/raw-material-fetch")
    public ResponseEntity<PerformanceResultDTO> getRawMaterialFetchPerformance() {
        return ResponseEntity.ok(performanceService.measureRawMaterialFetch());
    }
    
}

