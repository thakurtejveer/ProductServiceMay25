package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repository.CategoryRepository;
import com.scaler.productservicemay25.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
//       Optional<Product> product = productRepository.findById(id);
//       if(product.isEmpty()) {
//           throw new ProductNotFoundException("Product with given id : " + id + " is not found IN STORAGE DB", id);
//       }
//       return product.get();
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with given id : " + id + " is not found IN STORAGE DB", id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException{
//        Category category = product.getCategory();
//        if(category == null ) {
//            throw new CategoryNotFoundException("Product can't be saved without category id", "please try again with valid category");
//        }
//        // find category by title
//        Optional<Category> categoryRepositoryByTitle= categoryRepository.findByTitle(category.getTitle());
//        if(categoryRepositoryByTitle.isEmpty()) {
//            // create category as not present in database
//            category = categoryRepository.save(category);
//        } else {
//            category = categoryRepositoryByTitle.get();
//        }
//        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
