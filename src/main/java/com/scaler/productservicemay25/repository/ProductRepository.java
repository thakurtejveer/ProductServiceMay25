package com.scaler.productservicemay25.repository;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository // not needed if repository extends JpaRepository,
// auto proxy happen for ProductRepository and inject the bean
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    // select * from products where title like '%title%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    // find products where price >= 100 and price <= 1000
   List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    // product with a category - category is different table
    // select * from products where category_id = category.id
    List<Product> findByCategory(Category category);

    // select * from products where category_id = categoryId;
    List<Product> findAllByCategory_Id(Long categoryId);

    // select * from products t join categories c on  t.category_id = c.id where c.title = categoryTitle;
    List<Product> findAllByCategory_Title(String categoryTitle);

    // save + update
    public Product save(Product product);

    public void deleteById(Long id);
}
