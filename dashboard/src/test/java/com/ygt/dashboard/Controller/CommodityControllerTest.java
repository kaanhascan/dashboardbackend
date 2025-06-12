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
import com.ygt.dashboard.Model.Commodity;
import com.ygt.dashboard.Repository.CommodityRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CommodityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CommodityRepository commodityRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllCommodities() throws Exception {
        mockMvc.perform(get("/api/commodities"))
            .andExpect(status().isOk());
    }

    @Test
    public void testCreateCommodity() throws Exception {
        Commodity commodity = Commodity.builder()
            .commName("Test Commodity")
            .monthlyExpenses(1000)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(40)
            .pendingOrder(2)
            .currentStock(4)
            .status("test status")
            .suppliers("test supplier")
            .totalCommodity(5.0)
            .userId(10L)
            .build();
        mockMvc.perform(post("/api/commodities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commodity)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.commName").value("Test Commodity"))
            .andExpect(jsonPath("$.monthlyExpenses").value(1000))
            .andExpect(jsonPath("$.unit").value("kg"))
            .andExpect(jsonPath("$.restockPoint").value(40))
            .andExpect(jsonPath("$.pendingOrder").value(2))
            .andExpect(jsonPath("$.currentStock").value(4));
    }

    @Test 
    public void testGetByIdCommodity() throws Exception{
        Commodity commodity = commodityRepository.save(Commodity.builder()
            .commName("Test Commodity")
            .monthlyExpenses(1000)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(40)
            .pendingOrder(2)
            .currentStock(4)
            .status("test status")
            .suppliers("test supplier")
            .totalCommodity(5.0)
            .userId(10L)
            .build());
        mockMvc.perform(get("/api/commodities/" + commodity.getCommId()))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetByIdCommodityNotFound() throws Exception {
        mockMvc.perform(get("/api/commodities/9999"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateCommodity() throws Exception {
        Commodity existingCommodity = commodityRepository.save(Commodity.builder()
            .commName("Test Commodity")
            .monthlyExpenses(1000)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(40)
            .pendingOrder(2)
            .currentStock(4)
            .status("test status")
            .suppliers("test supplier")
            .totalCommodity(5.0)
            .userId(10L)
            .build());
        Commodity updatedCommodity = Commodity.builder()
            .commId(existingCommodity.getCommId())
            .commName("Updated Commodity")
            .monthlyExpenses(1200)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(50)
            .pendingOrder(3)
            .currentStock(6)
            .status("updated status")
            .suppliers("updated supplier")
            .totalCommodity(7.0)
            .userId(10L)
            .build();
        mockMvc.perform(put("/api/commodities/" + existingCommodity.getCommId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCommodity)))
            .andExpect(jsonPath("$.commName").value("Updated Commodity"))
            .andExpect(jsonPath("$.monthlyExpenses").value(1200))
            .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCommodityNotFound() throws Exception {
        Commodity updatedCommodity = Commodity.builder()
            .commId(9999L)
            .commName("Updated Commodity")
            .monthlyExpenses(1200)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(50)
            .pendingOrder(3)
            .currentStock(6)
            .status("updated status")
            .suppliers("updated supplier")
            .totalCommodity(7.0)
            .userId(10L)
            .build();
        mockMvc.perform(put("/api/commodities/9999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCommodity)))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteCommodity() throws Exception {
        Commodity existingCommodity = commodityRepository.save(Commodity.builder()
            .commName("Test Commodity")
            .monthlyExpenses(1000)
            .lastOrdered(LocalDate.now())
            .unit("kg")
            .restockPoint(40)
            .pendingOrder(2)
            .currentStock(4)
            .status("test status")
            .suppliers("test supplier")
            .totalCommodity(5.0)
            .userId(10L)
            .build());
        mockMvc.perform(delete("/api/commodities/" + existingCommodity.getCommId()))
            .andExpect(status().isOk());
    }
}
