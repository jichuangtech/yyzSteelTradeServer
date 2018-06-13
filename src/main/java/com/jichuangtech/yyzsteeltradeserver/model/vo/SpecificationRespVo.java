package com.jichuangtech.yyzsteeltradeserver.model.vo;

import java.math.BigDecimal;

public class SpecificationRespVo extends SpecificationVo{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SpecificationRespVo{" +
                "id=" + id +
                "} " + super.toString();
    }
}
