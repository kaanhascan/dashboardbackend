package com.ygt.dashboard.Service;

import com.ygt.dashboard.DTO.ProductionDTO;
import com.ygt.dashboard.Model.Production;
import com.ygt.dashboard.Repository.ProductionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductionServiceTest {

    @Mock
    private ProductionRepository productionRepository;

    @InjectMocks
    private ProductionService productionService;

    @Test
    void testGetAll() {
        ProductionDTO dto1 = new ProductionDTO(); 
        ProductionDTO dto2 = new ProductionDTO();
        when(productionRepository.getAllProductionDTOs()).thenReturn(Arrays.asList(dto1, dto2));

        List<ProductionDTO> result = productionService.getAll();

        assertEquals(2, result.size());
        verify(productionRepository, times(1)).getAllProductionDTOs();
    }

    @Test
    void testGetById_Found() {
        Production production = new Production();
        production.setProductionId(1L);
        when(productionRepository.findById(1L)).thenReturn(Optional.of(production));

        Production result = productionService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getProductionId());
    }

    @Test
    void testGetById_NotFound() {
        when(productionRepository.findById(99L)).thenReturn(Optional.empty());

        Production result = productionService.getById(99L);

        assertNull(result);
    }

    @Test
    void testSave() {
        Production production = new Production();
        when(productionRepository.save(production)).thenReturn(production);

        Production result = productionService.save(production);

        assertNotNull(result);
        verify(productionRepository, times(1)).save(production);
    }

    @Test
    void testDelete() {
        Long id = 5L;

        productionService.delete(id);

        verify(productionRepository, times(1)).deleteById(id);
    }
}
