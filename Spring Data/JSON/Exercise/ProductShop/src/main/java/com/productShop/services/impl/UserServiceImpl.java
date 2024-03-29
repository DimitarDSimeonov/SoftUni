package com.productShop.services.impl;

import com.google.gson.Gson;
import com.productShop.models.dto.*;
import com.productShop.models.entities.User;
import com.productShop.repositories.UserRepository;
import com.productShop.services.UserService;
import com.productShop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.productShop.constants.ConstantPath.USER_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public void seedUser() throws IOException {

        if(userRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(USER_FILE_PATH));

        Arrays.stream(gson.fromJson(fileContent, UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public List<UserWithSoldProductDto> findAllWithSoldProducts() {

        List<User> users = userRepository.findAllWhitSoldProductOrderByLastNameThenByFirstName();
                users
                        .forEach(user -> user.setSoldProducts(user.getSoldProducts().stream()
                                .filter(product -> product.getBuyer() != null).collect(Collectors.toSet())));

        return users.stream()
                .filter(user -> user.getSoldProducts().size() > 0)
                .map(user -> modelMapper.map(user, UserWithSoldProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserListDto findAllUserWithSoldProduct() {

        List<UserNameAgeAndSoldProductDto> users = userRepository.findAllWithSoldProductOrderByProductCountThenByLastName()
                .stream()
                .map(user -> modelMapper.map(user, UserNameAgeAndSoldProductDto.class))
                .collect(Collectors.toList());

        users
                .forEach(UserNameAgeAndSoldProductDto -> UserNameAgeAndSoldProductDto.getSoldProducts().setCount(UserNameAgeAndSoldProductDto.getSoldProducts().getProducts().size()));

        return new UserListDto(users);

    }
}
