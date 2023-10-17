package bg.softUni.ShopingList.repository;

import bg.softUni.ShopingList.model.entity.Product;
import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query ("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryName categoryName);
}
