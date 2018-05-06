package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Factory", schema = "steelTrade", catalog = "")
public class FactoryEntity {
    private int id;
    private String name;
    private List<SpecificationEntity> specList;
    private List<StockEntity> stockList;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactoryEntity that = (FactoryEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "factoryId", fetch = FetchType.EAGER)
    public List<SpecificationEntity> getSpecList() {
        return specList;
    }

    public void setSpecList(List<SpecificationEntity> specList) {
        this.specList = specList;
    }

    @OneToMany(mappedBy = "factoryId", fetch = FetchType.EAGER)
    public List<StockEntity> getStockList() {
        return stockList;
    }

    public void setStockList(List<StockEntity> stockList) {
        this.stockList = stockList;
    }

    @Override
    public String toString() {
        return "FactoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sepcList=" + specList +
                ", stockList=" + stockList +
                '}';
    }
}
