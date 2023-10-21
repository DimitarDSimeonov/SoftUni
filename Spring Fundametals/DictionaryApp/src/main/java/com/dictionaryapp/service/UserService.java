package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.service.UserLoginServiceModel;
import com.dictionaryapp.model.service.UserRegisterServiceModel;

public interface UserService {

    boolean register(UserRegisterServiceModel userServiceModel);

    UserLoginServiceModel getByUsernameAndPassword(String username, String password);

    User getLoggedUser();
}
