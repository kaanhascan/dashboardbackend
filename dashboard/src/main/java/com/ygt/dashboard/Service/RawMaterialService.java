package com.ygt.dashboard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.Model.RawMaterial;
import com.ygt.dashboard.Repository.RawMaterialRepository;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    public List<RawMaterial> getAll() {
        return rawMaterialRepository.findAll();
    }

    public RawMaterial getById(Long id) {
        return rawMaterialRepository.findById(id).orElse(null);
    }

    public RawMaterial save(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    public void delete(Long id) {
        rawMaterialRepository.deleteById(id);
    }
} 