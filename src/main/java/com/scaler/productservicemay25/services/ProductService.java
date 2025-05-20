package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(Long id);

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public boolean deleteProduct(Long id);
}
