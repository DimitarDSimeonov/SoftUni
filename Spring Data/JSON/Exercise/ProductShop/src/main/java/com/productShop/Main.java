package com.productShop;

import com.productShop.services.CategoryService;
import com.productShop.services.ProductService;
import com.productShop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Main implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    public Main(CategoryService categoryService, UserService userService, ProductService productService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START!!!");

        seedData();
    }

    private void seedData() throws IOException {
        categoryService.seedCategory();
        userService.seedUser();
        productService.seedProduct();
    }
}
