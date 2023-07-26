package com.productShop.repositories;

import com.productShop.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c " +
            "WHERE SIZE(c.products) > 0 " +
            "ORDER BY SIZE(c.products) DESC")
    List<Category> findAllOrderByProductCount();
}
