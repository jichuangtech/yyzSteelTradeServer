package com.jichuangtech.yyzsteeltradeserver.model.vo;

import java.math.BigDecimal;

public class SpecificationReqVo extends SpecificationVo{
    private Integer factoryId;

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    @Override
    public String toString() {
        return "SpecificationReqVo{" +
                "factoryId=" + factoryId +
                "} " + super.toString();
    }
}
