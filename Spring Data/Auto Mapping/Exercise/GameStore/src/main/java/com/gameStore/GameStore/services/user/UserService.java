package com.gameStore.GameStore.services.user;

import com.gameStore.GameStore.models.dto.UserLoginDto;
import com.gameStore.GameStore.models.dto.UserRegisterDto;

public interface UserService {
    void registerUser(String email, String password, String confirmPassword, String fullName);

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto loginUserDto);

    void logout();
}
