package com.productShop.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class CategorySeedDto {

    @Expose
    @Size(min =  3, max = 15)
    private String name;

    public CategorySeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
