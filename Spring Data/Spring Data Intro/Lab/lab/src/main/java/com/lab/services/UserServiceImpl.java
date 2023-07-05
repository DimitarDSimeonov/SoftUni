package com.lab.services;

import com.lab.entities.User;
import com.lab.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.file.FileAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void registerUser(User user) throws FileAlreadyExistsException {
        if(userRepository.getByUsername(user.getUsername()) == null) {
            userRepository.save(user);
        }else {
            throw new FileAlreadyExistsException("User is exist in database!");
        }

    }

    @Override
    public void printUserAge(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        System.out.println(user.getAge());
    }


}
