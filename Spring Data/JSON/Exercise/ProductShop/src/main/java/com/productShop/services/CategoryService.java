package com.productShop.services;

import com.productShop.models.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    Set<Category> randomCategories();

    void seedCategory() throws IOException;
}
