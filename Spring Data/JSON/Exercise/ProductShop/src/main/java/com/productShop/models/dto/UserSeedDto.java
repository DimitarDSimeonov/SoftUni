package com.productShop.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;

public class UserSeedDto {

    @Expose
    private String firstName;

    @Expose
    @NotNull
    private String lastName;

    @Expose
    private Integer age;

    public UserSeedDto() {
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
}
