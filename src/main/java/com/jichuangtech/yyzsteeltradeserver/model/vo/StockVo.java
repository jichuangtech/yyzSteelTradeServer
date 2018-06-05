package com.jichuangtech.yyzsteeltradeserver.model.vo;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockVo {
    private String contractNo;
    private int price;
    private int number;
    private int offset;
    private int rest;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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
                ", price=" + price +
                ", number=" + number +
                ", offset=" + offset +
                ", rest=" + rest +
                '}';
    }
}
