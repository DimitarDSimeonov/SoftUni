package bg.softUni.ShopingList.service.impl;

import bg.softUni.ShopingList.model.entity.Category;
import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import bg.softUni.ShopingList.repository.CategoryRepository;
import bg.softUni.ShopingList.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
       if (categoryRepository.count() == 0) {
           Arrays.stream(CategoryName.values())
                   .forEach(categoryName -> {
                       Category category = new Category(categoryName);

                       categoryRepository.save(category);
                   });
       }
    }
}
