package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    // Mocked bean of ProductService
    @MockitoBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void testGetSingleProduct_PositiveCase() throws ProductNotFoundException {
        // Arrange
        Long productId = 10L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setTitle("iphone 16");
        expectedProduct.setPrice(70000.0);

        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productController.getSingleProduct(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testGetSingleProduct_NegativeCase() throws ProductNotFoundException {
//        A- Arrange
        Long productId = 10L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setTitle("iphone 16");
        expectedProduct.setPrice(70000.0);

        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);

//        A - Act
        Product actualProduct =  productController.getSingleProduct(1000L);

//        A - Assert
        assertNotEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testGetAllProducts_PositiveCase() throws ProductNotFoundException {
        List<Product> expectedProducts = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        product1.setId(11111L);
        product1.setTitle("iphone 16");
        product1.setPrice(70000.0);

        product2.setId(22222L);
        product1.setTitle("iphone 17");
        product1.setPrice(80000.0);

        product3.setId(33333L);
        product3.setTitle("iphone 18");
        product3.setPrice(90000.0);

        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);

        when(productService.getAllProducts()).thenReturn(expectedProducts);

        List<Product> actualProducts = productController.getAllProducts();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testGetSingleProduct_ThrowProductNotFoundException() throws ProductNotFoundException {
        Long productId = -1L;

        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setTitle("iphone 16");
        expectedProduct.setPrice(70000.0);

        ProductNotFoundException productNotFoundException = new ProductNotFoundException("Product Not Found", productId);
        when(productService.getSingleProduct(productId)).thenThrow(productNotFoundException);

        Exception exception = assertThrows(ProductNotFoundException.class, () -> productController.getSingleProduct(productId));
        assertEquals(productNotFoundException.getMessage(), exception.getMessage());
    }
}