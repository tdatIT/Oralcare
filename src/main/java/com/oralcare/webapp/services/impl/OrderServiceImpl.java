package com.oralcare.webapp.services.impl;

import com.oralcare.webapp.model.Order;
import com.oralcare.webapp.repositories.OrderRepo;
import com.oralcare.webapp.services.EmailService;
import com.oralcare.webapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public boolean insertOrder(Order order, String name, String email) {
        try {
            if (!order.getOrderItemsByOrderId().isEmpty() &&
                    order.getUserId() != 0) {
                orderRepo.saveAndFlush(order);
                emailService.replyOrderMail(order, name, email);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
