package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Specification", schema = "steelTrade", catalog = "")
public class SpecificationEntity {
    private int id;
    private String diameter;
    private String length;
    private BigDecimal weight;
    private int number;
    private int offsetPrice;
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

    @Basic
    @Column(name = "factoryId", nullable = true)
    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecificationEntity that = (SpecificationEntity) o;

        if (id != that.id) return false;
        if (number != that.number) return false;
        if (offsetPrice != that.offsetPrice) return false;
        if (diameter != null ? !diameter.equals(that.diameter) : that.diameter != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (factoryId != null ? !factoryId.equals(that.factoryId) : that.factoryId != null) return false;

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
        result = 31 * result + (factoryId != null ? factoryId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SpecificationEntity{" +
                "id=" + id +
                ", diameter='" + diameter + '\'' +
                ", length='" + length + '\'' +
                ", weight=" + weight +
                ", number=" + number +
                ", offsetPrice=" + offsetPrice +
                ", factoryId=" + factoryId +
                '}';
    }
}
