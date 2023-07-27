package com.productShop.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductRootDto {

    @XmlElement(name = "user")
    List<UserWithSoldProductDto> users;

    public List<UserWithSoldProductDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductDto> users) {
        this.users = users;
    }
}
