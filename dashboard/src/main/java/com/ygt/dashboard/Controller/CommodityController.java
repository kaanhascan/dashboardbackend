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

import com.ygt.dashboard.DTO.CommodityDTO;
import com.ygt.dashboard.Model.Commodity;
import com.ygt.dashboard.Service.CommodityService;

@RestController
@RequestMapping("/api/commodities")
@CrossOrigin("*")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public ResponseEntity<List<CommodityDTO>> getAll() {
        List<CommodityDTO> commodities = commodityService.getAll();
        return ResponseEntity.ok(commodities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commodity> getById(@PathVariable Long id) {
        Commodity existing = commodityService.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(existing);
    }

    @PostMapping
    public Commodity create(@RequestBody Commodity commodity) {
        return commodityService.save(commodity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commodity> update(@PathVariable Long id, @RequestBody Commodity updated) {
        Commodity existing = commodityService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updated.setCommId(id);
        return ResponseEntity.ok(commodityService.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        commodityService.delete(id);
        return ResponseEntity.ok().build();
    }
} 