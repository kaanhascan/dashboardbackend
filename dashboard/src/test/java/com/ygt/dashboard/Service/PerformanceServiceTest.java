package com.ygt.dashboard.Service;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.DTO.ProductionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PerformanceServiceTest {

    @Mock
    private ProductionService productionService;

    @InjectMocks
    private PerformanceService performanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMeasureProductionFetch() {
        List<ProductionDTO> mockList = Collections.singletonList(new ProductionDTO());
        when(productionService.getAll()).thenReturn(mockList);

        PerformanceResultDTO result = performanceService.measureProductionFetch();

        assertNotNull(result);
        assertEquals(1, result.getRecordCount());
        assertTrue(result.getDurationMs() >= 0);
        assertTrue(result.getMemoryUsedKb() >= 0);
        assertTrue(result.getCpuPercent() >= 0);
    }
}
