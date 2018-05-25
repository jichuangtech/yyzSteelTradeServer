package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;

@Entity
@Table(name = "OrderGoods", schema = "steelTrade", catalog = "")
public class OrderGoodsEntity {
    @Id
    private int id;
    private int goodsId;
    private int stockId;
    private int carId;
    private int orderId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goodsId", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "stockId", nullable = false)
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "carId", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "orderId", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
