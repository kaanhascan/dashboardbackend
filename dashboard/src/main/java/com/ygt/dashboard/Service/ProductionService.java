package com.ygt.dashboard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygt.dashboard.DTO.ProductionDTO;
import com.ygt.dashboard.Model.Production;
import com.ygt.dashboard.Repository.ProductionRepository;



@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;


    @Transactional(readOnly = true)
    public List<ProductionDTO> getAll() {
        return productionRepository.getAllProductionDTOs();
    }

    public Production getById(Long id) {
        return productionRepository.findById(id).orElse(null);
    }


    public Production save(Production production) {
        return productionRepository.save(production);
    }



    public void delete(Long id) {
        productionRepository.deleteById(id);
    }
}
