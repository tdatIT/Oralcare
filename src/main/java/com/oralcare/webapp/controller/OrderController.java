package com.oralcare.webapp.controller;

import com.oralcare.webapp.model.CustomUserDetails;
import com.oralcare.webapp.model.Order;
import com.oralcare.webapp.model.OrderItems;
import com.oralcare.webapp.model.User;
import com.oralcare.webapp.services.OrderService;
import com.oralcare.webapp.services.ProductService;
import com.oralcare.webapp.services.UserService;
import com.oralcare.webapp.variable.VariableScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/mua-san-pham")
    public String getOrderPage(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String lastname = ((CustomUserDetails) authentication.getPrincipal()).getLastName();
            modelMap.addAttribute("lastname", lastname);
        }
        modelMap.addAttribute("count", VariableScope.count_request);
        return "order-product";
    }

    @GetMapping(value = "/dat-hang-thanh-cong")
    public String orderSuccess(ModelMap modelMap) {
        return "order-success";
    }

    @PostMapping(value = "/checkout-order")
    public ResponseEntity orderProduct(@RequestParam(required = true) String productId1,
                                       @RequestParam(required = true) String productId2,
                                       @RequestParam(required = true) String productId3,
                                       @RequestParam(required = true) String quantity,
                                       ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        String email = authentication.getName();
        User user = userService.findUserByUsername(email);
        if (user != null) {
            Order order = new Order();
            order.setUserId(user.getUserId());
            order.setAddress(user.getAddress());
            //create item by product id
            OrderItems item_1 = new OrderItems();
            item_1.setProductId(Integer.parseInt(productId1));
            item_1.setQuantity(Integer.parseInt(quantity));
            //item 2
            OrderItems item_2 = new OrderItems();
            item_2.setProductId(Integer.parseInt(productId2));
            item_2.setQuantity(Integer.parseInt(quantity));
            //item 3
            OrderItems item_3 = new OrderItems();
            item_3.setProductId(Integer.parseInt(productId3));
            item_3.setQuantity(Integer.parseInt(quantity));
            //create list item and add item
            List<OrderItems> items = new ArrayList<>();
            items.add(item_1);
            items.add(item_2);
            items.add(item_3);

            int amount = 0;
            for (OrderItems i : items) {
                amount += (i.getQuantity() * productService
                        .findById(i.getProductId())
                        .getPrice());
                i.setOrder(order);
            }
            order.setAmount(amount);
            //Add items in to order and info
            order.setOrderItemsByOrderId(items);
            if (orderService.insertOrder(order, user.getLastname(), user.getEmail())) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
