package com.productShop.models.dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListDto {

    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "user")
    private List<UserAgeAndProductsDto> users;

    public UserListDto() {
    }

    public UserListDto(List<UserAgeAndProductsDto> users) {
        this.users = users;
        this.count = users.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserAgeAndProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserAgeAndProductsDto> users) {
        this.users = users;
    }
}
