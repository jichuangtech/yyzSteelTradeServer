package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;

@Entity
@Table(name = "OrderGoods", schema = "steelTrade", catalog = "")
public class OrderGoodsEntity {
    private int id;
    private OrderEntity orderEntity;
    private GoodsEntity goods;
    private CarEntity car;
    private StockEntity stock;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderGoodsEntity that = (OrderGoodsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", nullable = false)
    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity order) {
        this.orderEntity = order;
    }

    @ManyToOne
    @JoinColumn(name = "goodsId", referencedColumnName = "id", nullable = false)
    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id", nullable = false)
    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
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
