package com.scaler.productservicemay25.repository;

import com.scaler.productservicemay25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    public Optional<Category> findByTitle(String title);

    public void deleteById(Long id);

    @Override
    Optional<Category> findById(Long id);
}
