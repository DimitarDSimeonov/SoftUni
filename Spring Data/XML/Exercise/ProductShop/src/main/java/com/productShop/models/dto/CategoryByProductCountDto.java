package com.productShop.models.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryByProductCountDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "products-count")
    private Integer count;

    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;

    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
