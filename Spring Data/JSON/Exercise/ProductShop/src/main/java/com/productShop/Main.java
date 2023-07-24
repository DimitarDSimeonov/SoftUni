package com.productShop;

import com.google.gson.Gson;
import com.productShop.models.dto.ProductNameAndPriceDto;
import com.productShop.models.dto.UserWithSoldProductDto;
import com.productShop.services.CategoryService;
import com.productShop.services.ProductService;
import com.productShop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.productShop.constants.ConstantPath.PRODUCT_IN_RANGE_PATH;
import static com.productShop.constants.ConstantPath.USER_WITH_SOLD_PRODUCT;

@Component
public class Main implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Gson gson;

    public Main(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START!!!");

        seedData();
        productsInRange();
        userSoldProduct();
    }

    private void seedData() throws IOException {
        categoryService.seedCategory();
        userService.seedUser();
        productService.seedProduct();
    }

    private void productsInRange() throws IOException {

        List<ProductNameAndPriceDto> productsDtos = productService
                .findAllProductsInRangeOrderByPrice(new BigDecimal(500), new BigDecimal(1000));

        String content = gson.toJson(productsDtos);

        writeToFile(PRODUCT_IN_RANGE_PATH, content);

    }

    private void userSoldProduct() throws IOException {

        List<UserWithSoldProductDto> users = userService
                .findAllWhitSoldProducts();

        String content = gson.toJson(users);

        writeToFile(USER_WITH_SOLD_PRODUCT, content);
    }

    private void writeToFile(String path,String content) throws IOException {
        Files.write(Path.of(path), Collections.singleton(content));
    }
}
