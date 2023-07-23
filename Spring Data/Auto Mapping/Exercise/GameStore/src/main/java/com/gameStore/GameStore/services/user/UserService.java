package com.gameStore.GameStore.services.user;

import com.gameStore.GameStore.models.dto.UserLoginDto;
import com.gameStore.GameStore.models.dto.UserRegisterDto;
import com.gameStore.GameStore.models.entities.User;

public interface UserService {

    User getLoggedInUser();

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto loginUserDto);

    void logout();
}
