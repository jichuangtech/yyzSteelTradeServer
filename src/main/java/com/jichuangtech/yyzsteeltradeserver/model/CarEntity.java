package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Car", schema = "steelTrade", catalog = "")
public class CarEntity {
    private int id;
    private String carLicense;
    private String telephone;
    private List<OrderGoodsEntity> orderGoodsList;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "carLicense", nullable = false, length = 60)
    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    @Basic
    @Column(name = "telephone", nullable = false, length = 60)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (id != carEntity.id) return false;
        if (carLicense != null ? !carLicense.equals(carEntity.carLicense) : carEntity.carLicense != null) return false;
        if (telephone != null ? !telephone.equals(carEntity.telephone) : carEntity.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carLicense != null ? carLicense.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
}
