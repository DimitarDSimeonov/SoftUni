package com.productShop.models.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ProductSoldListDto {

    @Expose
    private Integer count;

    @Expose
    private Set<ProductNamePriceDto> products;

    public ProductSoldListDto() {
    }

    public ProductSoldListDto(Set<ProductNamePriceDto> products) {
        this.count = products.size();
        this.products = products;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<ProductNamePriceDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductNamePriceDto> products) {
        this.products = products;
    }
}
