package com.productShop;

import com.productShop.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Main implements CommandLineRunner {

    private final CategoryService categoryService;

    public Main(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START!!!");

        seedData();
    }

    private void seedData() throws IOException {
        categoryService.seedCategory();
    }
}
