package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.service.UserLoginServiceModel;
import com.dictionaryapp.model.service.UserRegisterServiceModel;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private Long loginUserId;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserRegisterServiceModel userServiceModel) {

        if(userRepository.findByUsernameOrEmail(userServiceModel.getUsername(), userServiceModel.getPassword()).isPresent()) {
            return false;
        }

        userRepository.save(modelMapper.map(userServiceModel, User.class));
        return true;
    }

    @Override
    public UserLoginServiceModel getByUsernameAndPassword(String username, String password) {
        User user = userRepository
                .findByUsernameAndPassword(username, password)
                .orElse(null);

        if (user == null) {
            return null;
        }

        UserLoginServiceModel userLoginServiceModel = new UserLoginServiceModel();
        userLoginServiceModel.setUsername(user.getUsername());
        userLoginServiceModel.setPassword(user.getPassword());

        loginUserId =user.getId();

        return userLoginServiceModel;
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findById(loginUserId).get();
    }

    public Long getLoginUserId() {
        return this.loginUserId;
    }
}
