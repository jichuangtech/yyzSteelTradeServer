package com.jichuangtech.yyzsteeltradeserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Goods", schema = "steelTrade", catalog = "")
public class GoodsEntity {
    private List<OrderGoodsEntity> orderGoodsList;
    private ProductEntity product;
    private SpecificationEntity specification;

    @OneToMany(mappedBy = "goods", fetch = FetchType.EAGER)
    public List<OrderGoodsEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "specificationId", referencedColumnName = "id", nullable = false)
    public SpecificationEntity getSpecification() {
        return specification;
    }

    public void setSpecification(SpecificationEntity specification) {
        this.specification = specification;
    }

    private int id;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
