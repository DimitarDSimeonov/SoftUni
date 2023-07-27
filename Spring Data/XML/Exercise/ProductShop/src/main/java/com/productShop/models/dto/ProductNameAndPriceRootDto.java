package com.productShop.models.dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductNameAndPriceRootDto {

    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "product")
    private List<ProductNameAndPriceDto> products;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNameAndPriceDto> products) {
        this.products = products;
    }
}
