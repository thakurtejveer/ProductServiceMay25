package com.scaler.productservicemay25;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repository.CategoryRepository;
import com.scaler.productservicemay25.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceMay25ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery() {

        // Eager loading
        Optional<Product> product = productRepository.findById(3L);

        // Lazy loading
//        Optional<Category> categoryOption = categoryRepository.findById(2L);
//
//        System.out.println("Debug 1");
//        List<Product> products = categoryOption.get().getProducts();
//
//        System.out.println(products.get(0).getTitle());
//
        System.out.println("DEBUG 2");
    }

}
