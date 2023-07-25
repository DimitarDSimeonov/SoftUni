package com.productShop.models.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserNameAgeAndSoldProductDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private ProductSoldListDto soldProducts;

    public UserNameAgeAndSoldProductDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductSoldListDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldListDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
