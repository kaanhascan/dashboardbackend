package com.ygt.dashboard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ygt.dashboard.DTO.FacProductionDTO;
import com.ygt.dashboard.Model.FacProduction;
import com.ygt.dashboard.Repository.FacProductionRepository;

@Service
public class FacProductionService {
    @Autowired
    private FacProductionRepository facProductionRepository;

    @Transactional(readOnly = true)
    public List<FacProductionDTO> getAll() {
        return facProductionRepository.getAllFacProductionDTOs();
    }

    public FacProduction getById(Long id) {
        return facProductionRepository.findById(id).orElse(null);
    }

    public FacProduction save(FacProduction facProduction) {
        return facProductionRepository.save(facProduction);
    }

    public void delete(Long id) {
        facProductionRepository.deleteById(id);
    }
}
