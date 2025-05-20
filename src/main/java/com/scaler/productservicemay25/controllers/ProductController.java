package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        // should be implemented in service layer, make call to service layer
        return productService.getSingleProduct(productId);
    }

    //localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //localhost:8080/products/
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    //localhost:8080/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<Void> replaceProduct(@RequestBody Product product) {return null;}

    @PatchMapping()
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {return null;}

}
