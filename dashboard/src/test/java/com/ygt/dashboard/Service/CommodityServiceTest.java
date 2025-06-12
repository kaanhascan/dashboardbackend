package com.ygt.dashboard.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ygt.dashboard.Repository.CommodityRepository;
import com.ygt.dashboard.DTO.CommodityDTO;
import com.ygt.dashboard.Model.Commodity;

@ExtendWith(MockitoExtension.class)
public class CommodityServiceTest {
    
    @Mock
    private CommodityRepository commodityRepository;

    @InjectMocks
    private CommodityService commodityService;

    @Test
    void testGetAll() {
 
        CommodityDTO commodity1 = new CommodityDTO();
        CommodityDTO commodity2 = new CommodityDTO();
        when(commodityRepository.getAllCommodityDTOs()).thenReturn(Arrays.asList(commodity1, commodity2));

 
        List<CommodityDTO> result = commodityService.getAll();


        assertEquals(2, result.size());
        verify(commodityRepository, times(1)).getAllCommodityDTOs();
    }

    @Test
    void testGetById_Found() {
 
        Commodity commodity = new Commodity();
        commodity.setCommId(1L);
        when(commodityRepository.findById(1L)).thenReturn(Optional.of(commodity));


        Commodity result = commodityService.getById(1L);


        assertNotNull(result);
        assertEquals(1L, result.getCommId());
    }

    @Test
    void testGetById_NotFound() {

        when(commodityRepository.findById(99L)).thenReturn(Optional.empty());


        Commodity result = commodityService.getById(99L);


        assertNull(result);
    }

    @Test
    void testSave() {

        Commodity commodity = new Commodity();
        commodity.setCommName("Test Commodity");
        commodity.setMonthlyExpenses(1000);
        commodity.setLastOrdered(LocalDate.now());
        when(commodityRepository.save(any(Commodity.class))).thenReturn(commodity);


        Commodity result = commodityService.save(commodity);


        assertNotNull(result);
        assertEquals("Test Commodity", result.getCommName());
        verify(commodityRepository, times(1)).save(commodity);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        commodityService.delete(id);
        verify(commodityRepository, times(1)).deleteById(id);
    }
}
