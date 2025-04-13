package com.ygt.dashboard.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.Model.Sales;
import com.ygt.dashboard.Repository.SalesRepository;

@Service
public class SalesService {
    

    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAll(){
        return salesRepository.findAll();
    }

    public Sales getById(Long id){
        return salesRepository.findById(id).orElse(null);
    }


    public Sales save(Sales sales){
        return salesRepository.save(sales);
    }

    public void delete(Long id) {
        salesRepository.deleteById(id);
    }

}
