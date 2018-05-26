package com.jichuangtech.yyzsteeltradeserver.repository;

import com.jichuangtech.yyzsteeltradeserver.model.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer>{
    List<StockEntity> findAllByFactoryId(int factoryId);
}
