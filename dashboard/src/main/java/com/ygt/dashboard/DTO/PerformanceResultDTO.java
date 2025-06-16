package com.ygt.dashboard.DTO;


public class PerformanceResultDTO {
    private long durationMs;
    private long memoryUsedKb;
    private int recordCount;
    private int cpuPercent;
    private double jsonSizeKb;


    public PerformanceResultDTO(long durationMs, long memoryUsedKb, int recordCount, int cpuPercent, double jsonSizeKb) {
        this.durationMs = durationMs;
        this.memoryUsedKb = memoryUsedKb;
        this.recordCount = recordCount;
        this.cpuPercent = cpuPercent;
        this.jsonSizeKb = jsonSizeKb;
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

    public double getJsonSizeKb() {
        return jsonSizeKb;
    }
}