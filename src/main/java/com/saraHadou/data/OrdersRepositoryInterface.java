package com.saraHadou.data;

import com.saraHadou.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersRepositoryInterface
        extends JpaRepository< OrderEntity, Long > {

    public List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);
}
