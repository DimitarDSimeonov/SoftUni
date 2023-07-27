package com.productShop;

import com.productShop.models.dto.*;
import com.productShop.services.CategoryService;
import com.productShop.services.ProductService;
import com.productShop.services.UserService;
import com.productShop.utils.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

import static com.productShop.constants.ConstantPath.*;

@Component
public class Main implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final XmlParser xmlParser;


    public Main(CategoryService categoryService, UserService userService, ProductService productService, XmlParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START!!!");

//        seedData();
//        productsInRange();
//        userSoldProduct();
//        categoryByProductCount();
//        usersAndProducts();
    }

    private void seedData() throws IOException, JAXBException {
        if (categoryService.getCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(CATEGORY_FILE_PATH, CategorySeedRootDto.class);
            categoryService.seedCategory(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser.fromFile(USER_FILE_PATH, UserSeedRootDto.class);
            userService.seedUser(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0) {
            ProductSeedRootDto productSeedRootDto = xmlParser.fromFile(PRODUCT_FILE_PATH, ProductSeedRootDto.class);
            productService.seedProduct(productSeedRootDto.getProducts());
        }
    }

    private void productsInRange() throws JAXBException {

        ProductNameAndPriceRootDto product = productService
                .findAllProductsInRangeOrderByPrice(new BigDecimal(500), new BigDecimal(1000));

        xmlParser.writeToFile(PRODUCT_IN_RANGE_PATH, product);

    }

    private void userSoldProduct() throws JAXBException {

        UserWithSoldProductRootDto allWithSoldProducts = userService.findAllWithSoldProducts();

        xmlParser.writeToFile(USER_WITH_SOLD_PRODUCT,allWithSoldProducts);
    }

    private void categoryByProductCount() throws JAXBException {

        CategoryByProductCountRootDto category = categoryService.findAllByProductCount();

        xmlParser.writeToFile(CATEGORY_BY_PRODUCT_COUNT, category);

    }
//
//    private void usersAndProducts() throws IOException {
//
//        UserListDto user = userService.findAllUserWithSoldProduct();
//
//    }
}
