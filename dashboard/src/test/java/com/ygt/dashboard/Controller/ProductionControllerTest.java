package com.ygt.dashboard.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygt.dashboard.Model.Production;
import com.ygt.dashboard.Repository.ProductionRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductionRepository productionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProduction() throws Exception {
        Production production = Production.builder()
            .productName("Test Product")
            .batchNumber("B100")
            .unitsProduced(100)
            .defects(2)
            .qualityRate(95.5)
            .inspector("Inspector A")
            .status("Completed")
            .cycleTime(1.2)
            .productionRate(80.0)
            .machineEfficiency(90.0)
            .targetRate(85.0)
            .unitHour(1.5)
            .defectRate(1.5)
            .workingHour(8.0)
            .productionDate(LocalDate.now())
            .userId(10L)
            .build();

        mockMvc.perform(post("/api/production")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(production)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productName").value("Test Product"))
            .andExpect(jsonPath("$.batchNumber").value("B100"))
            .andExpect(jsonPath("$.unitsProduced").value(100));
    }

    @Test
    public void testGetAllProductions() throws Exception {

        mockMvc.perform(get("/api/production"))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        Production saved = productionRepository.save(Production.builder()
            .productName("Test Product")
            .batchNumber("B200")
            .unitsProduced(200)
            .defects(1)
            .qualityRate(98.0)
            .inspector("Inspector X")
            .status("In Progress")
            .cycleTime(1.3)
            .productionRate(85.0)
            .machineEfficiency(92.0)
            .targetRate(88.0)
            .unitHour(1.6)
            .defectRate(1.2)
            .workingHour(7.0)
            .productionDate(LocalDate.now())
            .userId(20L)
            .build());


        mockMvc.perform(get("/api/production/" + saved.getProductionId()))
            .andExpect(status().isOk());
    }

    @Test 
    public void testGetByIdNotFound() throws Exception {
        mockMvc.perform(get("/api/production/1232131231"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateProduction() throws Exception {
        Production saved = productionRepository.save(Production.builder()
            .productName("Test")
            .batchNumber("B123")
            .unitsProduced(100)
            .defects(3)
            .qualityRate(90.0)
            .inspector("Inspector B")
            .status("In Progress")
            .cycleTime(1.5)
            .productionRate(75.0)
            .machineEfficiency(88.0)
            .targetRate(80.0)
            .unitHour(1.4)
            .defectRate(2.0)
            .workingHour(7.5)
            .productionDate(LocalDate.now())
            .userId(5L)
            .build());


        Production updated = Production.builder()
            .productionId(saved.getProductionId())
            .productName("Updated Name")
            .batchNumber(saved.getBatchNumber())
            .unitsProduced(saved.getUnitsProduced())
            .defects(saved.getDefects())
            .qualityRate(saved.getQualityRate())
            .inspector(saved.getInspector())
            .status("Completed")
            .cycleTime(saved.getCycleTime())
            .productionRate(saved.getProductionRate())
            .machineEfficiency(saved.getMachineEfficiency())
            .targetRate(saved.getTargetRate())
            .unitHour(saved.getUnitHour())
            .defectRate(saved.getDefectRate())
            .workingHour(saved.getWorkingHour())
            .productionDate(saved.getProductionDate())
            .userId(saved.getUserId())
            .build();

        mockMvc.perform(put("/api/production/" + saved.getProductionId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updated)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productName").value("Updated Name"))
            .andExpect(jsonPath("$.status").value("Completed"));
    }

    @Test
    public void testUpdateProductionNotFound() throws Exception {
        Production updated = Production.builder()
            .productionId(999L) 
            .productName("Non-existent")
            .batchNumber("B999")
            .unitsProduced(50)
            .defects(0)
            .qualityRate(100.0)
            .inspector("Inspector Z")
            .status("Ready")
            .cycleTime(1.0)
            .productionRate(90.0)
            .machineEfficiency(95.0)
            .targetRate(85.0)
            .unitHour(1.2)
            .defectRate(0.5)
            .workingHour(8.0)
            .productionDate(LocalDate.now())
            .userId(30L)
            .build();

        mockMvc.perform(put("/api/production/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updated)))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteProduction() throws Exception {
        Production saved = productionRepository.save(Production.builder()
            .productName("ToDelete")
            .batchNumber("B001")
            .unitsProduced(50)
            .defects(1)
            .qualityRate(92.0)
            .inspector("Inspector C")
            .status("Ready")
            .cycleTime(1.1)
            .productionRate(78.0)
            .machineEfficiency(85.0)
            .targetRate(80.0)
            .unitHour(1.3)
            .defectRate(1.8)
            .workingHour(8.0)
            .productionDate(LocalDate.now())
            .userId(3L)
            .build());

        mockMvc.perform(delete("/api/production/" + saved.getProductionId()))
            .andExpect(status().isOk());
    }
}
