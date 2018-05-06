package com.jichuangtech.yyzsteeltradeserver.model.vo;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockVo {
    private String contractNo;
    private long timestamp;
    private int price;
    private int number;
    private int offset;
    private int factoryId;
    private int rest;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "StockVo{" +
                "contractNo='" + contractNo + '\'' +
                ", timestamp=" + timestamp +
                ", price=" + price +
                ", number=" + number +
                ", offset=" + offset +
                ", factoryId=" + factoryId +
                ", rest=" + rest +
                '}';
    }
}
