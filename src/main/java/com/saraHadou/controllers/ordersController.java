package com.saraHadou.controllers;

import com.saraHadou.models.Order;
 import com.saraHadou.data.OrdersDataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class ordersController {

    final OrdersDataAccessInterface<Order> service;

    @Autowired
    public ordersController(OrdersDataAccessInterface<Order> service) {
        this.service = service;
    }

    @GetMapping("/")
    public  List< Order > showAllOrders() {
        List< Order > orders = service.getOrders();
        return orders;
    }

    @GetMapping("/search/{searchTerm}")
    public  List< Order > searchOrders(@PathVariable(name = "searchTerm") String searchTerm) {
        List< Order > orders = service.searchOrders(searchTerm);
        return orders;
    }

    @PostMapping("/")
    public long addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable(name = "id") long id) {
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteOrder(@PathVariable(name = "id") long id) {
        return service.deleteOrder(id);
    }

    @PutMapping("/update/{id}")
    public Order deleteOrder(@RequestBody Order order, @PathVariable(name = "id") long id) {
        return service.updateOrder(id, order);
    }

}
