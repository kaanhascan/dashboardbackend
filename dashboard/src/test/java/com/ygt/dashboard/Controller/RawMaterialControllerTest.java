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
}
