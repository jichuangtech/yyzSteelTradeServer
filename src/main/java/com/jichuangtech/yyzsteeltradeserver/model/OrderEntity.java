package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Order", schema = "steelTrade", catalog = "")
public class OrderEntity {
    private int id;
    private int customerId;
    private int salesmanId;
    private Timestamp datetime;
    private List<OrderGoodsEntity> orderGoodsList;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customerId", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "salesmanId", nullable = false)
    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    @Basic
    @Column(name = "datetime", nullable = false)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER)
    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntity)) return false;

        OrderEntity that = (OrderEntity) o;

        if (getId() != that.getId()) return false;
        if (getCustomerId() != that.getCustomerId()) return false;
        if (getSalesmanId() != that.getSalesmanId()) return false;
        if (!getDatetime().equals(that.getDatetime())) return false;
        return getOrderGoodsList().equals(that.getOrderGoodsList());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCustomerId();
        result = 31 * result + getSalesmanId();
        result = 31 * result + getDatetime().hashCode();
        result = 31 * result + getOrderGoodsList().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", salesmanId=" + salesmanId +
                ", datetime=" + datetime +
                ", orderGoodsList=" + orderGoodsList +
                '}';
    }
}
