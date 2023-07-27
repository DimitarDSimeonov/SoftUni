package com.productShop.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductNamePriceAndSellerRootDto {

    @XmlElement(name = "product")
    private List<ProductNamePriceAndSellerDto> products;

    public List<ProductNamePriceAndSellerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNamePriceAndSellerDto> products) {
        this.products = products;
    }
}
