package com.ygt.dashboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygt.dashboard.Model.RawMaterial;
import com.ygt.dashboard.Repository.RawMaterialRepository;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RawMaterialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllRawMaterials() throws Exception {
        mockMvc.perform(get("/api/raw-materials"))
            .andExpect(status().isOk());
    }

    @Test
    public void testCreateRawMaterial() throws Exception {
        RawMaterial rawMaterial = RawMaterial.builder()
            .materialsName("Test Material")
            .monthlyExpenses(1000)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(40)
            .pendingOrders(2)
            .currentStock(4)
            .materialStatus("test status")
            .keySuppliers("test supplier")
            .totalMaterial(5.0)
            .userId(10L)
            .build();

        mockMvc.perform(post("/api/raw-materials")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rawMaterial)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.materialsName").value("Test Material"))
            .andExpect(jsonPath("$.monthlyExpenses").value(1000))
            .andExpect(jsonPath("$.materialUnit").value("kg"))
            .andExpect(jsonPath("$.reorderPoint").value(40))
            .andExpect(jsonPath("$.pendingOrders").value(2))
            .andExpect(jsonPath("$.currentStock").value(4));
    }

    @Test 
    public void testgetByIdRawMaterial() throws Exception{
        RawMaterial rawMaterial = rawMaterialRepository.save(RawMaterial.builder()
            .materialsName("Test Material")
            .monthlyExpenses(1000)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(40)
            .pendingOrders(2)
            .currentStock(4)
            .materialStatus("test status")
            .keySuppliers("test supplier")
            .totalMaterial(5.0)
            .userId(10L)
            .build());

        mockMvc.perform(get("/api/raw-materials/" + rawMaterial.getMaterialsId()))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetByIdRawMaterialNotFound() throws Exception {
        mockMvc.perform(get("/api/raw-materials/9999"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateRawMaterial() throws Exception {
        RawMaterial existingMaterial = rawMaterialRepository.save(RawMaterial.builder()
            .materialsName("Test Material")
            .monthlyExpenses(1000)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(40)
            .pendingOrders(2)
            .currentStock(4)
            .materialStatus("test status")
            .keySuppliers("test supplier")
            .totalMaterial(5.0)
            .userId(10L)
            .build());

        RawMaterial updatedMaterial = RawMaterial.builder()
            .materialsId(existingMaterial.getMaterialsId())
            .materialsName("Updated Material")
            .monthlyExpenses(1200)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(50)
            .pendingOrders(3)
            .currentStock(6)
            .materialStatus("updated status")
            .keySuppliers("updated supplier")
            .totalMaterial(7.0)
            .userId(10L)
            .build();


        mockMvc.perform(put("/api/raw-materials/" + existingMaterial.getMaterialsId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedMaterial)))
            .andExpect(jsonPath("$.materialsName").value("Updated Material"))
            .andExpect(jsonPath("$.monthlyExpenses").value(1200))
            .andExpect(status().isOk());

    }

    @Test
    public void testUpdateRawMaterialNotFound() throws Exception {
        RawMaterial updatedMaterial = RawMaterial.builder()
            .materialsId(9999L)
            .materialsName("Updated Material")
            .monthlyExpenses(1200)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(50)
            .pendingOrders(3)
            .currentStock(6)
            .materialStatus("updated status")
            .keySuppliers("updated supplier")
            .totalMaterial(7.0)
            .userId(10L)
            .build();

        mockMvc.perform(put("/api/raw-materials/9999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedMaterial)))
            .andExpect(status().isNotFound());
    }


    @Test
    public void testDeleteRawMaterial() throws Exception {
        RawMaterial existingMaterial = rawMaterialRepository.save(RawMaterial.builder()
            .materialsName("Test Material")
            .monthlyExpenses(1000)
            .lastOrderDate(LocalDate.now())
            .materialUnit("kg")
            .reorderPoint(40)
            .pendingOrders(2)
            .currentStock(4)
            .materialStatus("test status")
            .keySuppliers("test supplier")
            .totalMaterial(5.0)
            .userId(10L)
            .build());

        mockMvc.perform(delete("/api/raw-materials/" + existingMaterial.getMaterialsId()))
            .andExpect(status().isOk());
    }
}
