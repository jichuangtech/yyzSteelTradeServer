package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;

@Entity
@Table(name = "OrderGoods", schema = "steelTrade", catalog = "")
public class OrderGoodsEntity {
    private int id;
    private int goodsId;
    private int carId;
    private StockEntity stock;

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
    @Column(name = "carId", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderGoodsEntity that = (OrderGoodsEntity) o;

        if (id != that.id) return false;
        if (goodsId != that.goodsId) return false;
        if (carId != that.carId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsId;
        result = 31 * result + carId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "stockId", referencedColumnName = "id", nullable = false)
    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }
}
