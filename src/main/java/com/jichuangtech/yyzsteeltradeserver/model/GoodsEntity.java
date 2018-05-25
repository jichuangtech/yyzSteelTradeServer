package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Goods", schema = "steelTrade", catalog = "")
public class GoodsEntity {
    private int id;
    private BigDecimal price;
    private int number;
    private int productId;
    private int specificationId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (id != that.id) return false;
        if (number != that.number) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }

    @Id
    @Column(name = "productId", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    @Id
    @Column(name = "specificationId", nullable = false)
    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }
}
