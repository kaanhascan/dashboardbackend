package com.ygt.dashboard.Service;

import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.Model.FacProduction;
import com.ygt.dashboard.Repository.FacProductionRepository;


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
class FacProductionServiceTest {

    @Mock
    private FacProductionRepository facProductionRepository;

    @InjectMocks
    private FacProductionService facProductionService;

    @Test
    void testGetAll() {
        FacProductionDTO dto1 = new FacProductionDTO(); 
        FacProductionDTO dto2 = new FacProductionDTO();
        when(facProductionRepository.getAllFacProductionDTOs()).thenReturn(Arrays.asList(dto1, dto2));

        List<FacProductionDTO> result = facProductionService.getAll();

        assertEquals(2, result.size());
        verify(facProductionRepository, times(1)).getAllFacProductionDTOs();
    }

    @Test
    void testGetById_Found() {
        FacProduction facProduction = new FacProduction();
        facProduction.setProductionId(1L);
        when(facProductionRepository.findById(1L)).thenReturn(Optional.of(facProduction));

        FacProduction result = facProductionService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getProductionId());
    }

    @Test
    void testGetById_NotFound() {
        when(facProductionRepository.findById(99L)).thenReturn(Optional.empty());

        FacProduction result = facProductionService.getById(99L);

        assertNull(result);
    }

    @Test
    void testSave() {
        FacProduction production = new FacProduction();
        when(facProductionRepository.save(production)).thenReturn(production);

        FacProduction result = facProductionService.save(production);

        assertNotNull(result);
        verify(facProductionRepository, times(1)).save(production);
    }

    @Test
    void testDelete() {
        Long id = 5L;

        facProductionService.delete(id);

        verify(facProductionRepository, times(1)).deleteById(id);
    }
}
