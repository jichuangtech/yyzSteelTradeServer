package com.jichuangtech.yyzsteeltradeserver.repository;

import com.jichuangtech.yyzsteeltradeserver.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{
    CustomerEntity findById(int id);
}
