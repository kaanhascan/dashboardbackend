package com.ygt.dashboard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.DTO.CommodityDTO;
import com.ygt.dashboard.Model.Commodity;
import com.ygt.dashboard.Repository.CommodityRepository;

@Service
public class CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    public List<CommodityDTO> getAll() {
        return commodityRepository.getAllCommodityDTOs();
    }

    public Commodity getById(Long id) {
        return commodityRepository.findById(id).orElse(null);
    }

    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    public void delete(Long id) {
        commodityRepository.deleteById(id);
    }
} 