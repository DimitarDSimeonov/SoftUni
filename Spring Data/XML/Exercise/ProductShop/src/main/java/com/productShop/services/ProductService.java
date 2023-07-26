package com.productShop.services;

import com.productShop.models.dto.ProductNameAndPriceRootDto;
import com.productShop.models.dto.ProductSeedDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Long getCount();

    void seedProduct(List<ProductSeedDto> products) throws IOException;

    ProductNameAndPriceRootDto findAllProductsInRangeOrderByPrice(BigDecimal lowerPrice, BigDecimal upperPrice);
}
