package com.jichuangtech.yyzsteeltradeserver.model.vo;

public class StockReqVo extends StockVo{
    private int factoryId;
    private long timestamp;

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StockReqVo{" +
                "factoryId=" + factoryId +
                ", timestamp=" + timestamp +
                "} " + super.toString();
    }
}
