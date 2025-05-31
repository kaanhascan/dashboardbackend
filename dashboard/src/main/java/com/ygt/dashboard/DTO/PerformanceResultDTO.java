package com.ygt.dashboard.DTO;


public class PerformanceResultDTO {
    private long durationMs;
    private long memoryUsedKb;
    private int recordCount;
    private int cpuPercent;


    public PerformanceResultDTO(long durationMs, long memoryUsedKb, int recordCount,int cpuPercent) {
        this.durationMs = durationMs;
        this.memoryUsedKb = memoryUsedKb;
        this.recordCount = recordCount;

        this.cpuPercent = cpuPercent;
        
    }

    public long getDurationMs() {
        return durationMs;
    }

    public long getMemoryUsedKb() {
        return memoryUsedKb;
    }

    public int getRecordCount() {
        return recordCount;
    }
    public int getCpuPercent() {
        return cpuPercent;
    }
}