package com.ygt.dashboard.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.Model.Production;

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

        List<Production> data = productionService.getAll();

        long memAfter = getUsedMemory();
        long duration = (System.nanoTime() - start) / 1_000_000;
        double cpuPercent = getCpuLoadPercentage();

        return new PerformanceResultDTO(duration, memAfter - memBefore, data.size(),cpuPercent, data);
    }

    private long getUsedMemory() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / 1024;
    
    }
    public double getCpuLoadPercentage() {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        CentralProcessor processor = hal.getProcessor();

        long[] prevTicks = processor.getSystemCpuLoadTicks();
    
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        double load = processor.getSystemCpuLoadBetweenTicks(prevTicks);
        return load * 100;
    }
}

