package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(Long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public boolean deleteProduct(Long id);
}
