package com.ygt.dashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygt.dashboard.Model.Sales;
import com.ygt.dashboard.Service.SalesService;


@RestController
@RequestMapping("/api/sales")
@CrossOrigin("*")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAll() {
            return salesService.getAll();
    }

    @GetMapping("/{id}")
    public Sales getById(@PathVariable Long id) {
        return salesService.getById(id);
    }

    @PostMapping
    public Sales create(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> update(@PathVariable Long id, @RequestBody Sales updated) {
        Sales existing = salesService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updated.setProductId(id);
        return ResponseEntity.ok(salesService.save(updated));
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         salesService.delete(id);
         return ResponseEntity.ok().build();
     }
}
