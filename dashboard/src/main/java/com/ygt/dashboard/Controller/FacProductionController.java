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

import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.Model.FacProduction;
import com.ygt.dashboard.Service.FacProductionService;

@RestController
@RequestMapping("/api/facproduction")
@CrossOrigin("*")
public class FacProductionController {
    
    @Autowired
    private FacProductionService facProductionService;


    @GetMapping
    public ResponseEntity<List<FacProductionDTO>> getAll() {
        List<FacProductionDTO> facProductions = facProductionService.getAll();
        return ResponseEntity.ok(facProductions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacProduction> getById(@PathVariable Long id) {
        FacProduction existing = facProductionService.getById(id);
        if(existing != null) return ResponseEntity.ok(existing);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public FacProduction create(@RequestBody FacProduction facProduction) {
        return facProductionService.save(facProduction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacProduction> update(@PathVariable Long id, @RequestBody FacProduction updated) {
        FacProduction existing = facProductionService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        updated.setProductionId(id);
        return ResponseEntity.ok(facProductionService.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        facProductionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
