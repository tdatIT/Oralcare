package com.oralcare.webapp.repositories;

import com.oralcare.webapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
