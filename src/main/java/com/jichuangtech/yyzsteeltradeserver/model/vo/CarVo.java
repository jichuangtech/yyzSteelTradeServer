package com.jichuangtech.yyzsteeltradeserver.model.vo;

import com.jichuangtech.yyzsteeltradeserver.model.OrderGoodsEntity;

import java.util.List;

public class CarVo {

    private int id;
    private String carLicense;
    private String telephone;
    private List<OrderGoodsEntity> orderGoodsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    @Override
    public String toString() {
        return "CarVo{" +
                "id=" + id +
                ", carLicense='" + carLicense + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orderGoodsList=" + orderGoodsList +
                '}';
    }
}
