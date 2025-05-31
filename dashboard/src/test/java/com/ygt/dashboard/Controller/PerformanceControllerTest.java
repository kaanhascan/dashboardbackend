package com.ygt.dashboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PerformanceControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProductionFetchPerformance() throws Exception {
        mockMvc.perform(get("/performance/production-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").isNumber())
            .andExpect(jsonPath("$.memoryUsedKb").isNumber())
            .andExpect(jsonPath("$.recordCount").isNumber())
            .andExpect(jsonPath("$.cpuPercent").isNumber())
            .andExpect(jsonPath("$.durationMs").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.recordCount").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.lessThanOrEqualTo(100)));
    }

    @Test
    public void testGetRawMaterialFetchPerformance() throws Exception {
        mockMvc.perform(get("/performance/raw-material-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").isNumber())
            .andExpect(jsonPath("$.memoryUsedKb").isNumber())
            .andExpect(jsonPath("$.recordCount").isNumber())
            .andExpect(jsonPath("$.cpuPercent").isNumber())
            .andExpect(jsonPath("$.durationMs").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.recordCount").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.lessThanOrEqualTo(100)));
    }

    @Test
    public void testSalesFetchPerformance() throws Exception {
        mockMvc.perform(get("/performance/raw-material-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").isNumber())
            .andExpect(jsonPath("$.memoryUsedKb").isNumber())
            .andExpect(jsonPath("$.recordCount").isNumber())
            .andExpect(jsonPath("$.cpuPercent").isNumber())
            .andExpect(jsonPath("$.durationMs").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.recordCount").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.greaterThanOrEqualTo(0)))
            .andExpect(jsonPath("$.cpuPercent").value(org.hamcrest.Matchers.lessThanOrEqualTo(100)));
    }

    @Test
    public void testProductionFetchPerformanceResponseStructure() throws Exception {
        mockMvc.perform(get("/performance/production-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").exists())
            .andExpect(jsonPath("$.memoryUsedKb").exists())
            .andExpect(jsonPath("$.recordCount").exists())
            .andExpect(jsonPath("$.cpuPercent").exists());
    }

    @Test
    public void testRawMaterialFetchPerformanceResponseStructure() throws Exception {
        mockMvc.perform(get("/performance/raw-material-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").exists())
            .andExpect(jsonPath("$.memoryUsedKb").exists())
            .andExpect(jsonPath("$.recordCount").exists())
            .andExpect(jsonPath("$.cpuPercent").exists());
    }

    @Test
    public void testSalesFetchPerformanceResponseStructure() throws Exception {
        mockMvc.perform(get("/performance/raw-material-fetch"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.durationMs").exists())
            .andExpect(jsonPath("$.memoryUsedKb").exists())
            .andExpect(jsonPath("$.recordCount").exists())
            .andExpect(jsonPath("$.cpuPercent").exists());
    }

    @Test
    public void testInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/performance/invalid-endpoint"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testPerformanceEndpointsAreReasonablyFast() throws Exception {
        long startTime = System.currentTimeMillis();
        
        mockMvc.perform(get("/performance/production-fetch"))
            .andExpect(status().isOk());
            
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        

        assert duration < 5000 : "Performance endpoint took too long: " + duration + "ms";
    }

    @Test
    public void testMultipleConsecutiveCalls() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(get("/performance/production-fetch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.durationMs").isNumber());
                
            mockMvc.perform(get("/performance/raw-material-fetch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.durationMs").isNumber());
            
            mockMvc.perform(get("/performance/sales-fetch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.durationMs").isNumber());
        }
    }
}
