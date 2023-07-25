package com.productShop.services.impl;

import com.google.gson.Gson;
import com.productShop.models.dto.CategoryByProductCountDto;
import com.productShop.models.dto.CategorySeedDto;
import com.productShop.models.entities.Category;
import com.productShop.models.entities.Product;
import com.productShop.repositories.CategoryRepository;
import com.productShop.services.CategoryService;
import com.productShop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.productShop.constants.ConstantPath.CATEGORY_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public Set<Category> randomCategories() {

        int randomLength = ThreadLocalRandom.current().nextInt(1, 4);

        Set<Category> randomCategories = new HashSet<>();

        Long categoryCount = categoryRepository.count();

        for (int i = 0; i < randomLength; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1, categoryCount + 1);

            randomCategories.add(categoryRepository.findById(randomId).orElse(null));
        }

        return randomCategories;
    }

    @Override
    public void seedCategory() throws IOException {

        if(categoryRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(CATEGORY_FILE_PATH));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public List<CategoryByProductCountDto> findAllByProductCount() {

        return categoryRepository.findAllOrderByProductCount()
                .stream()
                .map(category -> {
                    CategoryByProductCountDto categoryByProductCountDto = new CategoryByProductCountDto();

                    BigDecimal sum = BigDecimal.ZERO;

                    for (Product product : category.getProducts()) {
                        sum = sum.add(product.getPrice());
                    }

                    categoryByProductCountDto.setCategory(category.getName());
                    categoryByProductCountDto.setProductCount(category.getProducts().size());
                    categoryByProductCountDto.setAveragePrice(sum.divide(new BigDecimal(category.getProducts().size()), 6, RoundingMode.HALF_UP));
                    categoryByProductCountDto.setTotalRevenue(sum);

                    return categoryByProductCountDto;
                })
                .collect(Collectors.toList());

    }
}
