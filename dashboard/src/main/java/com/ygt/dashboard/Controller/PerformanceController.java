package com.ygt.dashboard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.Service.PerformanceService;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/fac-production-fetch")
    public ResponseEntity<PerformanceResultDTO> getFacProductionFetchPerformance() {
        return ResponseEntity.ok(performanceService.measureFacProductionFetch());
    }

    @GetMapping("/commodity-fetch")
    public ResponseEntity<PerformanceResultDTO> getCommodityFetchPerformance() {
        return ResponseEntity.ok(performanceService.measureCommodityFetch());
    }

    @GetMapping("/sales-fetch")
    public ResponseEntity<PerformanceResultDTO> getSalesFetchPerformance() {
        return ResponseEntity.ok(performanceService.measureSalesFetch());
    }
    
}

