package com.saraHadou.data;

import com.saraHadou.models.Order;

import java.util.List;

public interface OrdersDataAccessInterface <T>{

    public List<T> getOrders();
    public T getById(long id);
    public List<T> searchOrders(String searchTerm);
    public long addOrder(T newOrder);
    public boolean deleteOrder(long id);
    public T updateOrder(long idToUpdate, T updatedOrder);

}
