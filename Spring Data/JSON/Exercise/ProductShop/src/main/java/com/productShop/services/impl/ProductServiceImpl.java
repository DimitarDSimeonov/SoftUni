package com.productShop.services.impl;

import com.google.gson.Gson;
import com.productShop.models.dto.ProductSeedDto;
import com.productShop.models.entities.Product;
import com.productShop.models.entities.User;
import com.productShop.repositories.ProductRepository;
import com.productShop.services.CategoryService;
import com.productShop.services.ProductService;
import com.productShop.services.UserService;
import com.productShop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.productShop.constants.ConstantPath.PRODUCT_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProduct() throws IOException {

        if(productRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(PRODUCT_FILE_PATH));

        ProductSeedDto[] productSeedDtos = gson.fromJson(fileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> modelMapper.map(productSeedDto, Product.class))
                .forEach(product -> {
                    product.setSellerId(userService.getRandomUser());
                    User buyer = userService.getRandomUser();
                    if (buyer.getId().equals(product.getSellerId().getId()) || product.getName().length() > 25) {
                        product.setBuyerId(null);
                    } else {
                        product.setBuyerId(buyer);
                    }

                    product.setCategories(categoryService.randomCategories());

                    productRepository.save(product);
                });
    }
}
