package com.ygt.dashboard.DTO;

import java.util.List;
import com.ygt.dashboard.Model.Production;

public class PerformanceResultDTO {
    private long durationMs;
    private long memoryUsedKb;
    private int recordCount;
    private List<Production> data;
    private double cpuPercent;


    public PerformanceResultDTO(long durationMs, long memoryUsedKb, int recordCount,double cpuPercent, List<Production> data) {
        this.durationMs = durationMs;
        this.memoryUsedKb = memoryUsedKb;
        this.recordCount = recordCount;

        this.cpuPercent = cpuPercent;
        this.data = data;
        
    }

    public long getDurationMs() {
        return durationMs;
    }
    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }
    public long getMemoryUsedKb() {
        return memoryUsedKb;
    }
    public void setMemoryUsedKb(long memoryUsedKb) {
        this.memoryUsedKb = memoryUsedKb;
    }
    public int getRecordCount() {
        return recordCount;
    }
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
    public List<Production> getData() {
        return data;
    }
    public void setData(List<Production> data) {
        this.data = data;
    }
    public double getCpuPercent() {
        return cpuPercent;
    }
    public void setCpuPercent(double cpuPercent) {
        this.cpuPercent = cpuPercent;
    }
}