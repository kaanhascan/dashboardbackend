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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


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
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<FacProductionDTO> data = facProductionService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        double jsonSizeKb = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            byte[] jsonBytes = objectMapper.writeValueAsBytes(data);
            jsonSizeKb = jsonBytes.length / 1024.0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent, jsonSizeKb);
    }

    

    
    public PerformanceResultDTO measureCommodityFetch() {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<CommodityDTO> data = CommodityService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        
        int cpuPercent = getCpuLoadPercentage();

        double jsonSizeKb = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            byte[] jsonBytes = objectMapper.writeValueAsBytes(data);
            jsonSizeKb = jsonBytes.length / 1024.0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent,jsonSizeKb);
    }

    

    
    public PerformanceResultDTO measureSalesFetch() {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<SalesDTO> data = SalesService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        double jsonSizeKb = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            byte[] jsonBytes = objectMapper.writeValueAsBytes(data);
            jsonSizeKb = jsonBytes.length / 1024.0;
        }catch (Exception e) {
            e.printStackTrace();
        }   

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(), cpuPercent, jsonSizeKb);
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
            
            
            return new PerformanceResultDTO(duration, memAfter - memBefore, recordCount, cpuPercent, 0);
            
        } catch (Exception e) {
            long memAfter = getUsedMemory();
            long duration = (System.nanoTime() - start) / 1_000_000;
            int cpuPercent = getCpuLoadPercentage();
            
            
            return new PerformanceResultDTO(duration, memAfter - memBefore, 0, cpuPercent, 0);
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

