package com.ygt.dashboard.Service;

import com.ygt.dashboard.DTO.CommodityDTO;
import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.DTO.PerformanceResultDTO;
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
    private FacProductionService facProductionService;

    @Mock
    private CommodityService commodityService;

    @Mock
    private SalesService salesService;

    @InjectMocks
    private PerformanceService performanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMeasureFacProductionFetch() {
        List<FacProductionDTO> mockList = Collections.singletonList(new FacProductionDTO());
        when(facProductionService.getAll()).thenReturn(mockList);

        PerformanceResultDTO result = performanceService.measureFacProductionFetch();

        assertNotNull(result);
        assertEquals(1, result.getRecordCount());
        assertTrue(result.getDurationMs() >= 0);
        assertTrue(result.getMemoryUsedKb() >= 0);
        assertTrue(result.getCpuPercent() >= 0);
    }

    @Test
    void testMeasureCommodityFetch() {
        List<CommodityDTO> mockList = Collections.singletonList(new CommodityDTO());
        when(commodityService.getAll()).thenReturn(mockList);

        PerformanceResultDTO result = performanceService.measureCommodityFetch();
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
