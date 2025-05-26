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

import com.ygt.dashboard.DTO.ProductionDTO;
import com.ygt.dashboard.Model.Production;
import com.ygt.dashboard.Service.ProductionService;

@RestController
@RequestMapping("/api/production")
@CrossOrigin("*")
public class ProductionController {
    
    @Autowired
    private ProductionService productionService;


    @GetMapping
    public ResponseEntity<List<ProductionDTO>> getAll() {
        List<ProductionDTO> productions = productionService.getAll();
        return ResponseEntity.ok(productions);
    }

    @GetMapping("/{id}")
    public Production getById(@PathVariable Long id) {
        return productionService.getById(id);
    }

    @PostMapping
    public Production create(@RequestBody Production production) {
        return productionService.save(production);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Production> update(@PathVariable Long id, @RequestBody Production updated) {
        Production existing = productionService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        updated.setProductionId(id);
        return ResponseEntity.ok(productionService.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
