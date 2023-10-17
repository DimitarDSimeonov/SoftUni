package bg.softUni.ShopingList.repository;

import bg.softUni.ShopingList.model.entity.Category;
import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    Optional<Category> findByName(CategoryName name);
}
