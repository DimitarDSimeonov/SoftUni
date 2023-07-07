package com.BookshopSystem.services;

import com.BookshopSystem.entities.Category;
import com.BookshopSystem.repositories.CategoryRepository;
import com.BookshopSystem.services.intefaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE_PATH = "src/main/resources/files/categories.txt";

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategory() throws IOException {

        if(categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORY_FILE_PATH))
                .stream().filter(row -> !row.isBlank())
                .forEach(row -> {
                    Category category = new Category();
                    category.setName(row);
                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();
        int random = ThreadLocalRandom.current().nextInt(1, 3);

        for (int i = 0; i < random; i++) {
            Long randomId = ThreadLocalRandom.current()
                    .nextLong(1, categoryRepository.count() + 1);

            Category category = categoryRepository.findById(randomId)
                    .orElse(null);
            categories.add(category);
        }
        return categories;
    }
}
