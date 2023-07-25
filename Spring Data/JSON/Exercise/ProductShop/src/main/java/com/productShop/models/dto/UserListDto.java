package com.productShop.models.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserListDto {

    @Expose
    private Integer usersCount;

    @Expose
    private Set<UserNameAgeAndSoldProductDto> users;

    public UserListDto() {
    }

    public UserListDto(Set<UserNameAgeAndSoldProductDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserNameAgeAndSoldProductDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserNameAgeAndSoldProductDto> users) {
        this.users = users;
    }
}
