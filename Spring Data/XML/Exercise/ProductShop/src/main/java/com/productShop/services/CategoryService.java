package com.productShop.services;

import com.productShop.models.dto.CategorySeedDto;
import com.productShop.models.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {

    Long getCount();

    Set<Category> randomCategories();

    void seedCategory(List<CategorySeedDto> categories) throws IOException;

//    List<CategoryByProductCountDto> findAllByProductCount();
}
