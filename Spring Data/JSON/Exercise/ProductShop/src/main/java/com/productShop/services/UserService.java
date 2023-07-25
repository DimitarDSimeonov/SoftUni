package com.productShop.services;

import com.productShop.models.dto.UserWithSoldProductDto;
import com.productShop.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User getRandomUser();

    void seedUser() throws IOException;

    List<UserWithSoldProductDto> findAllWithSoldProducts();

}
