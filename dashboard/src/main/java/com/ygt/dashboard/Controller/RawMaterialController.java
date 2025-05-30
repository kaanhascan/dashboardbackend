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


import com.ygt.dashboard.DTO.RawMaterialDTO;
import com.ygt.dashboard.Model.RawMaterial;
import com.ygt.dashboard.Service.RawMaterialService;

@RestController
@RequestMapping("/api/raw-materials")
@CrossOrigin("*")
public class RawMaterialController {
    
    @Autowired
    private RawMaterialService rawMaterialService;

    @GetMapping
    public ResponseEntity<List<RawMaterialDTO>> getAll() {
        List<RawMaterialDTO> rawMaterials= rawMaterialService.getAll();
        return ResponseEntity.ok(rawMaterials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawMaterial> getById(@PathVariable Long id) {
        RawMaterial existing = rawMaterialService.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(existing);
    }

    @PostMapping
    public RawMaterial create(@RequestBody RawMaterial rawMaterial) {
        return rawMaterialService.save(rawMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RawMaterial> update(@PathVariable Long id, @RequestBody RawMaterial updated) {
        RawMaterial existing = rawMaterialService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        updated.setMaterialsId(id);
        return ResponseEntity.ok(rawMaterialService.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        rawMaterialService.delete(id);
        return ResponseEntity.ok().build();
    }
} 