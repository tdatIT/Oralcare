package com.oralcare.webapp.repositories;

import com.oralcare.webapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
