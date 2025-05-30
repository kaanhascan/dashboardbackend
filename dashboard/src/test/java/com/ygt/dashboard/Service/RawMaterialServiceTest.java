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

import com.ygt.dashboard.Repository.RawMaterialRepository;
import com.ygt.dashboard.DTO.RawMaterialDTO;
import com.ygt.dashboard.Model.RawMaterial;

@ExtendWith(MockitoExtension.class)
public class RawMaterialServiceTest {
    
    @Mock
    private RawMaterialRepository rawMaterialRepository;

    @InjectMocks
    private RawMaterialService rawMaterialService;

    @Test
    void testGetAll() {
 
        RawMaterialDTO material1 = new RawMaterialDTO();
        RawMaterialDTO material2 = new RawMaterialDTO();
        when(rawMaterialRepository.getAllRawMaterialDTOs()).thenReturn(Arrays.asList(material1, material2));

 
        List<RawMaterialDTO> result = rawMaterialService.getAll();


        assertEquals(2, result.size());
        verify(rawMaterialRepository, times(1)).getAllRawMaterialDTOs();
    }

    @Test
    void testGetById_Found() {
 
        RawMaterial material = new RawMaterial();
        material.setMaterialsId(1L);
        when(rawMaterialRepository.findById(1L)).thenReturn(Optional.of(material));


        RawMaterial result = rawMaterialService.getById(1L);


        assertNotNull(result);
        assertEquals(1L, result.getMaterialsId());
    }

    @Test
    void testGetById_NotFound() {

        when(rawMaterialRepository.findById(99L)).thenReturn(Optional.empty());


        RawMaterial result = rawMaterialService.getById(99L);


        assertNull(result);
    }

    @Test
    void testSave() {

        RawMaterial material = new RawMaterial();
        material.setMaterialsName("Test Material");
        material.setMonthlyExpenses(1000);
        material.setLastOrderDate(LocalDate.now());
        when(rawMaterialRepository.save(any(RawMaterial.class))).thenReturn(material);


        RawMaterial result = rawMaterialService.save(material);


        assertNotNull(result);
        assertEquals("Test Material", result.getMaterialsName());
        verify(rawMaterialRepository, times(1)).save(material);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        rawMaterialService.delete(id);
        verify(rawMaterialRepository, times(1)).deleteById(id);
    }
}
