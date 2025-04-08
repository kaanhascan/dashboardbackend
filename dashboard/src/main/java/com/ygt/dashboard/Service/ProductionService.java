package com.ygt.dashboard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.Model.Production;
import com.ygt.dashboard.Repository.ProductionRepository;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;


    public List<Production> getAll() {
        return productionRepository.findAll();
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
