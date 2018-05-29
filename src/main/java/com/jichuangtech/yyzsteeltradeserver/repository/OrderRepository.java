package com.jichuangtech.yyzsteeltradeserver.repository;

import com.jichuangtech.yyzsteeltradeserver.model.CarEntity;
import com.jichuangtech.yyzsteeltradeserver.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
    OrderEntity findById(int id);
}
