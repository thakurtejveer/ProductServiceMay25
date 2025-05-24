package com.scaler.productservicemay25.repository;

import com.scaler.productservicemay25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    public Optional<Category> findByTitle(String title);
}
