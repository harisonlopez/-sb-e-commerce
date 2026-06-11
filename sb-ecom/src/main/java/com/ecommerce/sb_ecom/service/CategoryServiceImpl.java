package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final List<Category> categories = new ArrayList<>();
    private Long nextId =1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
        return category;
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Category with id " + id + " not found") );
        categories.remove(category);
        return "Category with categoryId: %d deleted successful".formatted(id);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category existingCategory  = categories.stream()
                .filter((c)-> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Category with id " + categoryId + " not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        return existingCategory;
    }

}
