package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.models.Category;

public interface CategoryService {

    public void deleteCategory(Long id);

    public Category getCategory(Long id);
}
