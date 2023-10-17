package bg.softUni.ShopingList.service;

import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import bg.softUni.ShopingList.model.service.ProductServiceModel;
import bg.softUni.ShopingList.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalProductSum();

    List<ProductViewModel> getAllProductByCategoryName(CategoryName categoryName);

    void buyById(Long id);

    void byAll();
}
