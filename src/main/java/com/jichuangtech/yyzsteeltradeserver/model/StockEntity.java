package com.jichuangtech.yyzsteeltradeserver.model;

import com.jichuangtech.yyzsteeltradeserver.utils.DateUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "stock", schema = "steelTrade", catalog = "")
public class StockEntity {
    private int id;
    private String contractNo;
    private Timestamp datetime;
    private int price;
    private int number;
    private int rest;
    private int offset;
    private List<OrderGoodsEntity> orderGoodsList;
    private Integer factoryId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contractNo", nullable = false, length = 60)
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Basic
    @Column(name = "datetime", nullable = false)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "rest", nullable = false)
    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    @Basic
    @Column(name = "offset", nullable = false)
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Column(name = "factoryId", nullable = true)
    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER)
    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockEntity)) return false;

        StockEntity that = (StockEntity) o;

        if (getId() != that.getId()) return false;
        if (getPrice() != that.getPrice()) return false;
        if (getNumber() != that.getNumber()) return false;
        if (getRest() != that.getRest()) return false;
        if (getOffset() != that.getOffset()) return false;
        if (getContractNo() != null ? !getContractNo().equals(that.getContractNo()) : that.getContractNo() != null)
            return false;
        if (getDatetime() != null ? !getDatetime().equals(that.getDatetime()) : that.getDatetime() != null)
            return false;
        if (getOrderGoodsList() != null ? !getOrderGoodsList().equals(that.getOrderGoodsList()) : that.getOrderGoodsList() != null)
            return false;
        return getFactoryId() != null ? getFactoryId().equals(that.getFactoryId()) : that.getFactoryId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getContractNo() != null ? getContractNo().hashCode() : 0);
        result = 31 * result + (getDatetime() != null ? getDatetime().hashCode() : 0);
        result = 31 * result + getPrice();
        result = 31 * result + getNumber();
        result = 31 * result + getRest();
        result = 31 * result + getOffset();
        result = 31 * result + (getOrderGoodsList() != null ? getOrderGoodsList().hashCode() : 0);
        result = 31 * result + (getFactoryId() != null ? getFactoryId().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "StockEntity{" +
                "id=" + id +
                ", contractNo='" + contractNo + '\'' +
                ", datetime=" + datetime +
                ", price=" + price +
                ", number=" + number +
                ", rest=" + rest +
                ", offset=" + offset +
                ", orderGoodsList=" + orderGoodsList +
                ", factoryId=" + factoryId +
                '}';
    }
}
