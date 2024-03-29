package com.plannerapp.repo;

import com.plannerapp.model.entity.User;
import com.plannerapp.model.service.UserLoginServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
