package com.saraHadou.services;

import com.saraHadou.models.Order;

import java.util.List;

public interface OrdersServiceInterface {

    public void init();

    public void destroy();

    public List< Order > getOrders();

    public Order getById(long id);

    public List< Order > searchOrders(String searchTerm);

    public long addOrder(Order newOrder);

    public boolean deleteOrder(long id);

    public Order updateOrder(long idToUpdate, Order updatedOrder);

}
