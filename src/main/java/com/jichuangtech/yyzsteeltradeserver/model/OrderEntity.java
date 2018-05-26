package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "SteelOrder", schema = "steelTrade", catalog = "")
public class OrderEntity {
    private int id;
    private Timestamp datetime;
    private CustomerEntity customer;
    private SalesmanEntity salesman;
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
    @Column(name = "datetime", nullable = false)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (datetime != null ? !datetime.equals(that.datetime) : that.datetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "salesmanId", referencedColumnName = "id", nullable = false)
    public SalesmanEntity getSalesman() {
        return salesman;
    }

    public void setSalesman(SalesmanEntity salesman) {
        this.salesman = salesman;
    }

    @OneToMany(mappedBy = "orderEntity", fetch = FetchType.EAGER)
    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
}
