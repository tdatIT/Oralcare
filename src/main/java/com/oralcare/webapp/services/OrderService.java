package com.oralcare.webapp.services;

import com.oralcare.webapp.model.Order;

import java.util.List;

public interface OrderService {
    boolean insertOrder(Order order, String name, String email);

    List<Order> findAll();
}
