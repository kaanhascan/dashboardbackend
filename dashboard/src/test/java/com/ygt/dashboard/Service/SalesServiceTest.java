package com.ygt.dashboard.Service;

import com.ygt.dashboard.Repository.SalesRepository;
import com.ygt.dashboard.DTO.SalesDTO;
import com.ygt.dashboard.Model.Sales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SalesServiceTest {
    

    @Mock
    private SalesRepository salesRepository;

    @InjectMocks
    private SalesService salesService;

    @Test
    void testGetAll() {
        SalesDTO sales1 = new SalesDTO();
        SalesDTO sales2 = new SalesDTO();
        when(salesRepository.getAllSalesDTOs()).thenReturn(Arrays.asList(sales1, sales2));

        List<SalesDTO> result = salesService.getAll();
        assertEquals(2, result.size());
        verify(salesRepository,times(1)).getAllSalesDTOs();
    }


    @Test
    void testGetById_Found() {
        Sales sales = new Sales();
        sales.setProductId(1L);
        when(salesRepository.findById(1L)).thenReturn(java.util.Optional.of(sales));

        Sales result = salesService.getById(1L);
        assertEquals(1L, result.getProductId());
    }

    @Test
    void testGetById_NotFound(){
        when(salesRepository.findById(99L)).thenReturn(java.util.Optional.empty());

        Sales result = salesService.getById(99L);
        assertEquals(null, result);
    }


    @Test
    void testSave(){
        Sales sales = new Sales();
        sales.setProductId(1L);
        when(salesRepository.save(sales)).thenReturn(sales);

        Sales result = salesService.save(sales);
        assertEquals(1L, result.getProductId());
        verify(salesRepository, times(1)).save(sales);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        salesService.delete(id);
        verify(salesRepository, times(1)).deleteById(id);
    }
    

}
