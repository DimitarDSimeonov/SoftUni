package com.lab.services;

import com.lab.entities.User;

import java.nio.file.FileAlreadyExistsException;

public interface UserService {

    void registerUser(User user) throws FileAlreadyExistsException;

    void printUserAge(Long id);
}
