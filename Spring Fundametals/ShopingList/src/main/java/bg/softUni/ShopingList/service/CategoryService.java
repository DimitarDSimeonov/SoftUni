package bg.softUni.ShopingList.service;

import bg.softUni.ShopingList.model.entity.Category;
import bg.softUni.ShopingList.model.entity.enums.CategoryName;

public interface CategoryService {

    void initCategories();

    Category findByName(CategoryName categoryName);
}
