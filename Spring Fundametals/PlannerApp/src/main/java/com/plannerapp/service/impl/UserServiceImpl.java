package com.plannerapp.service.impl;

import com.plannerapp.model.entity.User;
import com.plannerapp.model.service.UserServiceModel;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {

        if(userRepository.findByUsernameOrEmail(userServiceModel.getUsername(), userServiceModel.getPassword()).isPresent()) {
            return false;
        }

        userRepository.save(modelMapper.map(userServiceModel, User.class));
        return true;
    }
}
