package com.jichuangtech.yyzsteeltradeserver.repository;

import com.jichuangtech.yyzsteeltradeserver.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>{
    CarEntity findById(int id);
}
