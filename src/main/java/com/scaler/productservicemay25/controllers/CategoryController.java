package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long catId) {
        categoryService.deleteCategory(catId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long catId) {
        return new ResponseEntity<>(
                categoryService.getCategory(catId),
                HttpStatus.OK);
    }
}
