package com.saraHadou.services;

import com.saraHadou.data.OrdersDataAccessInterface;
import com.saraHadou.models.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdersService implements OrdersServiceInterface {

    @Autowired
    private OrdersDataAccessInterface<Order> orderDAO;

    @Override
    public void init() {
        System.out.println("Init method of the Orders Service");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the Orders Service");
    }

    @Override
    public List< Order > getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    public Order getById(long id) {
        return orderDAO.getById(id);
    }

    @Override
    public List< Order > searchOrders(String searchTerm) {
        return orderDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOrder(Order newOrder) {
        return orderDAO.addOrder(newOrder);
    }

    @Override
    public boolean deleteOrder(long id) {
        return orderDAO.deleteOrder(id);
    }

    @Override
    public Order updateOrder(long idToUpdate, Order updatedOrder) {
        return orderDAO.updateOrder(idToUpdate, updatedOrder);
    }
}
