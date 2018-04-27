package com.jichuangtech.yyzsteeltradeserver.repository;

import com.jichuangtech.yyzsteeltradeserver.model.FactoryEntity;
import com.jichuangtech.yyzsteeltradeserver.model.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer>{
}
