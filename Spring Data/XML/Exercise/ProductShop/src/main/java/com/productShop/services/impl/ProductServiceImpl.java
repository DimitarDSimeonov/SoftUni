package com.productShop.services.impl;

import com.productShop.models.dto.ProductNamePriceAndSellerDto;
import com.productShop.models.dto.ProductNamePriceAndSellerRootDto;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public Long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProduct(List<ProductSeedDto> products) throws IOException {

        products.stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> modelMapper.map(productSeedDto, Product.class))
                .forEach(product -> {
                    product.setSeller(userService.getRandomUser());
                    User buyer = userService.getRandomUser();
                    if (buyer.getId().equals(product.getSeller().getId()) || product.getName().length() > 25) {
                        product.setBuyer(null);
                    } else {
                        product.setBuyer(buyer);
                    }

                    product.setCategories(categoryService.randomCategories());

                    productRepository.save(product);
                });
    }

    @Override
    public ProductNamePriceAndSellerRootDto findAllProductsInRangeOrderByPrice(BigDecimal lowerPrice, BigDecimal upperPrice) {
         List<ProductNamePriceAndSellerDto> products = productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowerPrice, upperPrice)
                .stream()
                .map(product -> {
                    ProductNamePriceAndSellerDto productNameAndPriceDto = modelMapper
                                .map(product, ProductNamePriceAndSellerDto.class);

                    productNameAndPriceDto.setSeller(String.format("%s %s", product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());

         ProductNamePriceAndSellerRootDto product =  new ProductNamePriceAndSellerRootDto();
         product.setProducts(products);
         return product;
    }
}
