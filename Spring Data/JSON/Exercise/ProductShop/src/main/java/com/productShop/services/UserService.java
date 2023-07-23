package com.productShop.services;

import com.productShop.models.entities.User;

import java.io.IOException;

public interface UserService {

    User getRandomUser();

    void seedUser() throws IOException;
}
