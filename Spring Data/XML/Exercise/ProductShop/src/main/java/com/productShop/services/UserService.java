package com.productShop.services;

import com.productShop.models.dto.UserSeedDto;
import com.productShop.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    Long getCount();

    User getRandomUser();

    void seedUser(List<UserSeedDto> users) throws IOException;

//    List<UserWithSoldProductDto> findAllWithSoldProducts();
//
//    UserListDto findAllUserWithSoldProduct();
}
