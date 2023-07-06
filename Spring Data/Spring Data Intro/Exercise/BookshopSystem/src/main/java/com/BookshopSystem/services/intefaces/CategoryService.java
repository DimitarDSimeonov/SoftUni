package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategory() throws IOException;

    Set<Category> getRandomCategories();
}
