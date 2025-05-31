package com.ygt.dashboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @Test
    public void testGetSalesByIdNotFound() throws Exception {
        mockMvc.perform(get("/api/sales/9999")) 
            .andExpect(status().isNotFound());
    }

    @Test 
    public void testCreateSales() throws Exception {
        Sales sales = Sales.builder()
            .productName("New Product")
            .totalOrders(50)
            .productSold(5)
            .revenue(250.0)
            .newCustomers(100)
            .unitsSold(3)
            .status("available")
            .topCustomers("New Customer")
            .salesDate(LocalDate.now())
            .unitPrice(75)
            .salesAddress("456 New St")
            .userId(1L)
            .build();

        mockMvc.perform(post("/api/sales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sales)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productName").value("New Product"))
            .andExpect(jsonPath("$.totalOrders").value(50));
    }

    @Test
    public void testUpdateSales() throws Exception {
        Sales existingSales = salesRepository.save(Sales.builder()
            .productName("Old Product")
            .totalOrders(30)
            .productSold(10)
            .revenue(300.0)
            .newCustomers(150)
            .unitsSold(5)
            .status("available")
            .topCustomers("Old Customer")
            .salesDate(LocalDate.now())
            .unitPrice(60)
            .salesAddress("789 Old St")
            .userId(1L)
            .build());

        Sales updatedSales = Sales.builder()
            .productName("Updated Product")
            .totalOrders(40)
            .productSold(20)
            .revenue(400.0)
            .newCustomers(200)
            .unitsSold(10)
            .status("available")
            .topCustomers("Updated Customer")
            .salesDate(LocalDate.now())
            .unitPrice(80)
            .salesAddress("101 Updated St")
            .userId(1L)
            .build();

        mockMvc.perform(put("/api/sales/" + existingSales.getProductId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedSales)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productName").value("Updated Product"))
            .andExpect(jsonPath("$.totalOrders").value(40));
    }

    @Test
    public void testDeleteSales() throws Exception {
        Sales existingSales = salesRepository.save(Sales.builder()
            .productName("Product to Delete")
            .totalOrders(20)
            .productSold(2)
            .revenue(100.0)
            .newCustomers(50)
            .unitsSold(1)
            .status("available")
            .topCustomers("Customer to Delete")
            .salesDate(LocalDate.now())
            .unitPrice(50)
            .salesAddress("123 Delete St")
            .userId(1L)
            .build());

        mockMvc.perform(delete("/api/sales/" + existingSales.getProductId()))
            .andExpect(status().isOk());
    }

}
