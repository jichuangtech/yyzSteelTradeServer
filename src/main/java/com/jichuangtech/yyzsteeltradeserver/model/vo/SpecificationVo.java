package com.jichuangtech.yyzsteeltradeserver.model.vo;

import java.math.BigDecimal;

public class SpecificationVo {
    private String diameter;
    private String length;
    private BigDecimal weight;
    private int number;
    private int offsetPrice;

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOffsetPrice() {
        return offsetPrice;
    }

    public void setOffsetPrice(int offsetPrice) {
        this.offsetPrice = offsetPrice;
    }

    @Override
    public String toString() {
        return "SpecificationVo{" +
                "diameter='" + diameter + '\'' +
                ", length='" + length + '\'' +
                ", weight=" + weight +
                ", number=" + number +
                ", offsetPrice=" + offsetPrice +
                '}';
    }
}
