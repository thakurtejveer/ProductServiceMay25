package com.scaler.productservicemay25;

import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceMay25ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery() {
        Product product = productRepository.findProuctByGivenId(1L);
        System.out.println("DEBUG");
    }

}
