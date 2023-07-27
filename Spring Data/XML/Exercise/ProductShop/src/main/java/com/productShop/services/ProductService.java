package com.productShop.services;

import com.productShop.models.dto.ProductNamePriceAndSellerRootDto;
import com.productShop.models.dto.ProductSeedDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Long getCount();

    void seedProduct(List<ProductSeedDto> products) throws IOException;

    ProductNamePriceAndSellerRootDto findAllProductsInRangeOrderByPrice(BigDecimal lowerPrice, BigDecimal upperPrice);
}
