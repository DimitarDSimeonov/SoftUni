package com.productShop.repositories;

import com.productShop.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id) > 0 " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllWhitSoldProductOrderByLastNameThenByFirstName();

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id) > 0 " +
            "ORDER BY (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id) DESC, u.lastName")
    List<User> findAllWithSoldProductOrderByProductCountThenByLastName();
}
