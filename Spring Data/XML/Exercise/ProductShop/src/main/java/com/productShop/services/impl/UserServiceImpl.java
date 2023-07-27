package com.productShop.services.impl;

import com.productShop.models.dto.*;
import com.productShop.models.entities.User;
import com.productShop.repositories.UserRepository;
import com.productShop.services.UserService;
import com.productShop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Long getCount() {
        return userRepository.count();
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public void seedUser(List<UserSeedDto> users) {

        if(userRepository.count() > 0) {
            return;
        }

        users.stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public UserWithSoldProductRootDto findAllWithSoldProducts() {

        List<User> users = userRepository.findAllWhitSoldProductOrderByLastNameThenByFirstName();
                users
                        .forEach(user -> user.setSoldProducts(user.getSoldProducts().stream()
                                .filter(product -> product.getBuyer() != null).collect(Collectors.toSet())));

        List<UserWithSoldProductDto> userWithSoldProductDtos = users.stream()
                .filter(user -> user.getSoldProducts().size() > 0)
                .map(user -> modelMapper.map(user, UserWithSoldProductDto.class))
                .collect(Collectors.toList());

        UserWithSoldProductRootDto rootDto = new UserWithSoldProductRootDto();
        rootDto.setUsers(userWithSoldProductDtos);
        return rootDto;
    }

//    @Override
//    public UserListDto findAllUserWithSoldProduct() {
//
////        List<UserNameAgeAndSoldProductDto> users = userRepository.findAllWithSoldProductOrderByProductCountThenByLastName()
////                .stream()
////                .map(user -> modelMapper.map(user, UserNameAgeAndSoldProductDto.class))
////                .collect(Collectors.toList());
////
////        users
////                .forEach(UserNameAgeAndSoldProductDto -> UserNameAgeAndSoldProductDto.getSoldProducts().setCount(UserNameAgeAndSoldProductDto.getSoldProducts().getProducts().size()));
////
////        return new UserListDto(users);
//
//    }
}
