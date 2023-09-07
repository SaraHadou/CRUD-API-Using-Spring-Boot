package com.saraHadou.data;

import com.saraHadou.models.Order;
import com.saraHadou.models.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class OrderDataService implements OrdersDataAccessInterface<Order>{

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List< Order > getOrders() {
        return jdbcTemplate.query("SELECT * FROM ORDERS", new OrderMapper());
    }

    @Override
    public Order getById(long id) {
        List<Order> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?", new OrderMapper(), id);
        if (results.size() > 0) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List< Order > searchOrders(String searchTerm) {
        return jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ? ", new OrderMapper(), "%" + searchTerm + "%") ;
    }

    @Override
    public long addOrder(Order newOrder) {
        return jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER," +
                        " PRODUCT_NAME, PRICE, QTY) VALUES (?, ?, ?, ?)",
                newOrder.getOrderNo(),
                newOrder.getProductName(),
                newOrder.getPrice(),
                newOrder.getQuantity());
    }

    @Override
    public boolean deleteOrder(long id) {
        int results = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID = ?", id);
        if (results > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Order updateOrder(long idToUpdate, Order updatedOrder) {
         int results = jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, " +
                "PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?",
                updatedOrder.getOrderNo(),
                updatedOrder.getProductName(),
                updatedOrder.getPrice(),
                updatedOrder.getQuantity(),
                idToUpdate);
         if (results > 0) {
             return updatedOrder;
         } else {
             return null;
         }

    }
}
