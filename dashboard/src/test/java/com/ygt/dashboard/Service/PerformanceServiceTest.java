package com.ygt.dashboard.Service;

import com.ygt.dashboard.DTO.PerformanceResultDTO;
import com.ygt.dashboard.DTO.ProductionDTO;
import com.ygt.dashboard.DTO.RawMaterialDTO;
import com.ygt.dashboard.DTO.SalesDTO;

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

    @Mock
    private RawMaterialService rawMaterialService;

    @Mock
    private SalesService salesService;

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

    @Test
    void testMeasureRawMaterialFetch() {
        List<RawMaterialDTO> mockList = Collections.singletonList(new RawMaterialDTO());
        when(rawMaterialService.getAll()).thenReturn(mockList);

        PerformanceResultDTO result = performanceService.measureRawMaterialFetch();
        assertNotNull(result);
        assertEquals(1, result.getRecordCount());
        assertTrue(result.getDurationMs() >= 0);
        assertTrue(result.getMemoryUsedKb() >= 0);
        assertTrue(result.getCpuPercent() >= 0);
    }

    @Test
    void testMeasureSalesFetch() {
        List<SalesDTO> mockList = Collections.singletonList(new SalesDTO());
        when(salesService.getAll()).thenReturn(mockList);

        PerformanceResultDTO result = performanceService.measureSalesFetch();
        assertNotNull(result);
        assertEquals(1, result.getRecordCount());
        assertTrue(result.getDurationMs() >= 0);
        assertTrue(result.getMemoryUsedKb() >= 0);
        assertTrue(result.getCpuPercent() >= 0);
    }
}
