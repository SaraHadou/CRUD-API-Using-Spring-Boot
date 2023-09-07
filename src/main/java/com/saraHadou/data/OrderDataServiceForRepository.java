package com.saraHadou.data;

import com.saraHadou.models.Order;
import com.saraHadou.models.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class OrderDataServiceForRepository implements OrdersDataAccessInterface<Order> {

    @Autowired
    OrdersRepositoryInterface orderRepo;

    private JdbcTemplate jdbcTemplate;

    public OrderDataServiceForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List< Order > getOrders() {
        Iterable<OrderEntity> entities = orderRepo.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderEntity entity: entities) {
            orders.add(modelMapper.map(entity, Order.class));
        }
         return orders;
    }

    @Override
    public Order getById(long id) {
        OrderEntity entity = orderRepo.findById(id).orElse(null);
        Order model = modelMapper.map(entity, Order.class);
        return model;
    }

    @Override
    public List< Order > searchOrders(String searchTerm) {
        Iterable<OrderEntity> entities = orderRepo.findByProductNameContainingIgnoreCase(searchTerm);
        List<Order> orders = new ArrayList<>();
        for (OrderEntity entity: entities) {
            orders.add(modelMapper.map(entity, Order.class));
        }
        return orders;
    }

    @Override
    public long addOrder(Order newOrder) {
        OrderEntity entity = modelMapper.map(newOrder, OrderEntity.class);
        OrderEntity result = orderRepo.save(entity);
        if (result == null) {
            return 0;
        } else {
            return result.getId();
        }
    }

    @Override
    public boolean deleteOrder(long id) {
        orderRepo.deleteById(id);
        return true;
    }

    @Override
    public Order updateOrder(long idToUpdate, Order updatedOrder) {
        OrderEntity entity = modelMapper.map(updatedOrder, OrderEntity.class);
        OrderEntity result = orderRepo.save(entity);
        Order model = modelMapper.map(result, Order.class);
        return model;
    }
}
