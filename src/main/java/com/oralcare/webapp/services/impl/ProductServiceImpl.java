package com.oralcare.webapp.services.impl;

import com.oralcare.webapp.model.Product;
import com.oralcare.webapp.repositories.ProductRepo;
import com.oralcare.webapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElseThrow();
    }
}
