package com.saraHadou.data;

import com.saraHadou.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface<Order> {

    List<Order> orders = new ArrayList<>();

    public OrdersFakeDAO() {
        orders.add(new Order(0L, "000","Sky diving", 500.0f, 1));
        orders.add(new Order(1L, "001","Zip line the Grand Canyon", 450.0f, 1));
        orders.add(new Order(2L, "002","Lemonade by the pool", 30.0f, 2));
    }

    @Override
    public List< Order > getOrders() {
        return orders;
    }

    @Override
    public Order getById(long id) {
        List<Order> order = orders
                .stream()
                .filter(o -> o.getId() == id)
                .collect(Collectors.toList());
        return order.get(0);
    }

    @Override
    public List< Order > searchOrders(String searchTerm) {
        List<Order> foundItems = orders
                .stream()
                .filter(order -> order.getProductName().toLowerCase()
                        .contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
        return foundItems;
    }

    @Override
    public long addOrder(Order newOrder) {
        boolean success = orders.add(newOrder);
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean deleteOrder(long id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Order updateOrder(long idToUpdate, Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == idToUpdate) {
                orders.set(i, updatedOrder);
                return orders.get(i);
            }
        }
        return null;
    }
}
