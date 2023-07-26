package com.productShop.models.dto;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class UserListDto {

    @Expose
    private Integer usersCount;

    @Expose
    private List<UserNameAgeAndSoldProductDto> users;

    public UserListDto() {
    }

    public UserListDto(List<UserNameAgeAndSoldProductDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserNameAgeAndSoldProductDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserNameAgeAndSoldProductDto> users) {
        this.users = users;
    }
}
