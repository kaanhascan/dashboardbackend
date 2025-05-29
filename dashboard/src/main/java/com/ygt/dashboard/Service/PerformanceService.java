package com.ygt.dashboard.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.DTO.ProductionDTO;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;


@Service
public class PerformanceService {
    @Autowired
    private ProductionService productionService;

    public PerformanceResultDTO measureProductionFetch() {
        long start = System.nanoTime();
        long memBefore = getUsedMemory();

        List<ProductionDTO> data = productionService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        int cpuPercent = getCpuLoadPercentage();

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(),cpuPercent);
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

