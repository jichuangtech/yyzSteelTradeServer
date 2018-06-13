package com.jichuangtech.yyzsteeltradeserver.model.vo;

import com.jichuangtech.yyzsteeltradeserver.model.SpecificationEntity;
import com.jichuangtech.yyzsteeltradeserver.model.StockEntity;

import java.util.List;

public class FactorySpecVo {
    private List<SpecificationRespVo> specificationList;

    public List<SpecificationRespVo> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationRespVo> specificationList) {
        this.specificationList = specificationList;
    }

    @Override
    public String toString() {
        return "FactorySpecVo{" +
                "specificationList=" + specificationList +
                '}';
    }
}
