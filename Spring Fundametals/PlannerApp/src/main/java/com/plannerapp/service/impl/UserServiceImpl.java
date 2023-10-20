package com.plannerapp.service.impl;

import com.plannerapp.model.entity.User;
import com.plannerapp.model.service.UserLoginServiceModel;
import com.plannerapp.model.service.UserRegisterServiceModel;
import com.plannerapp.model.view.TaskViewModel;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private Long loggedUserId;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
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
        userLoginServiceModel.setId(user.getId());
        userLoginServiceModel.setUsername(user.getUsername());
        userLoginServiceModel.setPassword(user.getPassword());

        this.loggedUserId = user.getId();

        return userLoginServiceModel;

    }

    @Override
    public User getLoggedUser() {
        return userRepository.findById(loggedUserId).get();
    }
}
