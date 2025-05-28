package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
