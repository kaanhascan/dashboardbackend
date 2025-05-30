package com.ygt.dashboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygt.dashboard.Model.Sales;
import com.ygt.dashboard.Repository.SalesRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SalesControllerTest {
    

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllSales() throws Exception {
        
        
        mockMvc.perform(get("/api/sales"))
            .andExpect(status().isOk());
    }

    @Test void testGetSalesById() throws Exception {
        Sales existingSales = salesRepository.save(Sales.builder()
            .productName("Test Product")
            .totalOrders(100)
            .productSold(15)
            .revenue(500.0)
            .newCustomers(200)
            .unitsSold(10)
            .status("available")
            .topCustomers("Top Customer")
            .salesDate(LocalDate.now())
            .unitPrice(50)
            .salesAddress("123 Test St")
            .userId(1L)
            .build());
        
        
            mockMvc.perform(get("/api/sales/" + existingSales.getProductId()))
                .andExpect(status().isOk());
    }

}
