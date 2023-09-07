package com.saraHadou.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper< Order > {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        Order order = new Order(rs.getLong("ID"),
                rs.getString("ORDER_NUMBER"),
                rs.getString("PRODUCT_NAME"),
                rs.getFloat("PRICE"),
                rs.getInt("QTY"));
        return order;
    }

}
