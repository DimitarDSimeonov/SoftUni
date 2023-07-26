package com.productShop.services.impl;

import com.productShop.models.dto.CategorySeedDto;
import com.productShop.models.entities.Category;
import com.productShop.repositories.CategoryRepository;
import com.productShop.services.CategoryService;
import com.productShop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Long getCount() {

        return categoryRepository.count();
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
    public void seedCategory(List<CategorySeedDto> categories) throws IOException {

        categories.stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

//    @Override
//    public List<CategoryByProductCountDto> findAllByProductCount() {
//
////        return categoryRepository.findAllOrderByProductCount()
////                .stream()
////                .map(category -> {
////                    CategoryByProductCountDto categoryByProductCountDto = new CategoryByProductCountDto();
////
////                    BigDecimal sum = BigDecimal.ZERO;
////
////                    for (Product product : category.getProducts()) {
////                        sum = sum.add(product.getPrice());
////                    }
////
////                    categoryByProductCountDto.setCategory(category.getName());
////                    categoryByProductCountDto.setProductCount(category.getProducts().size());
////                    categoryByProductCountDto.setAveragePrice(sum.divide(new BigDecimal(category.getProducts().size()), 6, RoundingMode.HALF_UP));
////                    categoryByProductCountDto.setTotalRevenue(sum);
////
////                    return categoryByProductCountDto;
////                })
////                .collect(Collectors.toList());
//
//    }
}
