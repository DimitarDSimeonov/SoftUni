package com.gameStore.GameStore.services.user;

import com.gameStore.GameStore.models.dto.UserLoginDto;
import com.gameStore.GameStore.models.dto.UserRegisterDto;
import com.gameStore.GameStore.models.entities.User;
import com.gameStore.GameStore.repositories.UserRepository;
import com.gameStore.GameStore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violation = validationUtil.violation(userRegisterDto);

        if(!violation.isEmpty()) {
            violation.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto, User.class);

        user.setAdministrator(userRepository.count() == 0);

        System.out.println(user.getFullName() + " was registered");

        userRepository.save(user);
    }

    @Override
    public void loginUser(UserLoginDto loginUserDto) {

        Set<ConstraintViolation<UserLoginDto>> violation = validationUtil.violation(loginUserDto);

        if(!violation.isEmpty()) {
            violation.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository
                .findByEmailAndPassword(loginUserDto.getEmail(), loginUserDto.getPassword())
                .orElse(null);

        if(user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        System.out.println("Successfully logged in " + user.getFullName());

        loggedInUser = user;
    }

    @Override
    public void logout() {
        if(loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }

        System.out.println("User " + loggedInUser.getFullName() + " successfully logged out");
        loggedInUser = null;
    }
}
