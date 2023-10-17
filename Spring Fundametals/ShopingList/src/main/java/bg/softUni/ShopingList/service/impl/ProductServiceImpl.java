package bg.softUni.ShopingList.service.impl;

import bg.softUni.ShopingList.model.entity.Product;
import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import bg.softUni.ShopingList.model.service.ProductServiceModel;
import bg.softUni.ShopingList.model.view.ProductViewModel;
import bg.softUni.ShopingList.repository.ProductRepository;
import bg.softUni.ShopingList.service.CategoryService;
import bg.softUni.ShopingList.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {

        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService
                .findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalProductSum() {
        BigDecimal sum = productRepository
                .findTotalProductsSum();
        return sum != null ? sum : BigDecimal.valueOf(0);
    }

    @Override
    public List<ProductViewModel> getAllProductByCategoryName(CategoryName categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void byAll() {
        productRepository.deleteAll();
    }
}
