package com.productShop.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryByProductCountRootDto {

    @XmlElement(name = "category")
    private List<CategoryByProductCountDto> categories;

    public List<CategoryByProductCountDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryByProductCountDto> categories) {
        this.categories = categories;
    }
}
