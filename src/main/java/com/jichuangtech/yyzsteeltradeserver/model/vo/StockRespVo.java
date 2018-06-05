package com.jichuangtech.yyzsteeltradeserver.model.vo;

import java.sql.Timestamp;

public class StockRespVo extends StockVo{
    private int id;
    private Timestamp datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "StockRespVo{" +
                "id=" + id +
                ", datetime=" + datetime +
                "} " + super.toString();
    }
}
