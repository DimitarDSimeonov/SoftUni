package com.plannerapp.service;

import com.plannerapp.model.entity.User;
import com.plannerapp.model.service.UserLoginServiceModel;
import com.plannerapp.model.service.UserRegisterServiceModel;

public interface UserService {
    boolean register(UserRegisterServiceModel userServiceModel);

    UserLoginServiceModel getByUsernameAndPassword(String username, String password);

    User getLoggedUser();

}
