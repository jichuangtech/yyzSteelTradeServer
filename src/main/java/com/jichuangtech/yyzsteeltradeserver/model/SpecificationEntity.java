package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Specification", schema = "steelTrade", catalog = "")
public class SpecificationEntity {
    private int id;
    private String diameter;
    private String length;
    private BigDecimal weight;
    private int number;
    private int offsetPrice;
    private List<GoodsEntity> goodsList;
    private FactoryEntity factory;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "diameter", nullable = false, length = 60)
    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "length", nullable = false, length = 60)
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Basic
    @Column(name = "weight", nullable = false, precision = 3)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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
    @Column(name = "offsetPrice", nullable = false)
    public int getOffsetPrice() {
        return offsetPrice;
    }

    public void setOffsetPrice(int offsetPrice) {
        this.offsetPrice = offsetPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecificationEntity entity = (SpecificationEntity) o;

        if (id != entity.id) return false;
        if (number != entity.number) return false;
        if (offsetPrice != entity.offsetPrice) return false;
        if (diameter != null ? !diameter.equals(entity.diameter) : entity.diameter != null) return false;
        if (length != null ? !length.equals(entity.length) : entity.length != null) return false;
        if (weight != null ? !weight.equals(entity.weight) : entity.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + offsetPrice;
        return result;
    }

    @OneToMany(mappedBy = "specification", fetch = FetchType.EAGER)
    public List<GoodsEntity> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsEntity> goodsList) {
        this.goodsList = goodsList;
    }

    @ManyToOne
    @JoinColumn(name = "factoryId", referencedColumnName = "id")
    public FactoryEntity getFactory() {
        return factory;
    }

    public void setFactory(FactoryEntity factory) {
        this.factory = factory;
    }
}
