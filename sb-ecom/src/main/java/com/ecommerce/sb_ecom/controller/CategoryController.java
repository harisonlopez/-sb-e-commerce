package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    //    @Qualifier - we use qualifier to tell spring which class should we use in this case if we had 2 implementation classes for the service interface how will the spring boot know which implementation class to use so we use qualifier and pass the name inside it like we did here if we only have one implementation class we don't need to add qualifier
    @Autowired
    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //public api
    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        if (allCategories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allCategories);
    }

    //admin api
    @PostMapping("/admin/categories")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
        Category data = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        String message = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(message);
    }
    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category,@PathVariable Long categoryId){
        Category updatedCategory = categoryService.updateCategory(categoryId, category);
        return ResponseEntity.ok(updatedCategory);

    }
}
