package com.saraHadou;

import com.saraHadou.data.OrderDataServiceForRepository;
import com.saraHadou.data.OrdersDataAccessInterface;

import com.saraHadou.services.OrdersService;
import com.saraHadou.services.OrdersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean(name = "OrderService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrdersServiceInterface getOrdersService() {
        return new OrdersService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name = "OrderDAO")
    @RequestScope
    public OrdersDataAccessInterface getDataService() {
        return new OrderDataServiceForRepository(dataSource);
        // return new OrderDataService();
    }
}
