package com.jichuangtech.yyzsteeltradeserver.model.vo;

import com.jichuangtech.yyzsteeltradeserver.model.StockEntity;

import java.util.List;

public class FactoryStockVo {
    private List<StockRespVo> stockList;

    public List<StockRespVo> getStockList() {
        return stockList;
    }

    public void setStockList(List<StockRespVo> stockList) {
        this.stockList = stockList;
    }

    @Override
    public String toString() {
        return "FactoryStockVo{" +
                "stockList=" + stockList +
                '}';
    }
}
