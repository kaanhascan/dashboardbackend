package com.ygt.dashboard.Service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ygt.dashboard.DTO.CommodityDTO;
import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.DTO.LoginRequest;
import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.DTO.SalesDTO;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;


@Service
public class PerformanceService {
    @Autowired
    private FacProductionService facProductionService;

    @Autowired
    private CommodityService CommodityService;

    @Autowired
    private SalesService SalesService;
    
    @Autowired
    private RestTemplate restTemplate;


    public PerformanceResultDTO measureFacProductionFetch() {
        return measureFacProductionFetch(1000); 
    }

    
    public PerformanceResultDTO measureFacProductionFetch(int limit) {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<FacProductionDTO> data = facProductionService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent);
    }

    
    public PerformanceResultDTO measureCommodityFetch() {
        return measureCommodityFetch(1000); 
    }

    
    public PerformanceResultDTO measureCommodityFetch(int limit) {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<CommodityDTO> data = CommodityService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent);
    }

    
    public PerformanceResultDTO measureSalesFetch() {
        return measureSalesFetch(1000); 
    }

    
    public PerformanceResultDTO measureSalesFetch(int limit) {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<SalesDTO> data = SalesService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent);
    }

    public PerformanceResultDTO measureLoginFetch() {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        LoginRequest loginRequest = new LoginRequest();
        
        loginRequest.setUsername("Ahmet");
        loginRequest.setPassword("123456");

        try {
            var response = restTemplate.postForEntity(
                "http://localhost:8080/api/auth/login", 
                loginRequest, 
                Map.class
            );
            
            long memAfter = getUsedMemory();
            long duration = (System.nanoTime() - start) / 1_000_000;
            int cpuPercent = getCpuLoadPercentage();
            
            int recordCount = response.getStatusCode().is2xxSuccessful() ? 1 : 0;
            
            return new PerformanceResultDTO(duration, memAfter - memBefore, recordCount, cpuPercent);
            
        } catch (Exception e) {
            long memAfter = getUsedMemory();
            long duration = (System.nanoTime() - start) / 1_000_000;
            int cpuPercent = getCpuLoadPercentage();
            
            return new PerformanceResultDTO(duration, memAfter - memBefore, 0, cpuPercent);
        }
    }

    private long getUsedMemory() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / 1024;
    
    }
    public int getCpuLoadPercentage() {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        CentralProcessor processor = hal.getProcessor();

        long[] prevTicks = processor.getSystemCpuLoadTicks();

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    double load = processor.getSystemCpuLoadBetweenTicks(prevTicks);
    return (int) (load * 100); 
    }
}

