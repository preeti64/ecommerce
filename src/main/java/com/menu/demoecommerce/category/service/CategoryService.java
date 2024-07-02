package com.menu.demoecommerce.category.service;

import com.menu.demoecommerce.category.model.Category;
import com.menu.demoecommerce.category.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long categoryId, Category category){
        Category updatedCategory = categoryRepository.findById(categoryId).orElse(null);
        category.setCategoryName(updatedCategory.getCategoryName());
        category.setCategoryDescription(updatedCategory.getCategoryDescription());
        category.setImageUrl(updatedCategory.getImageUrl());
        categoryRepository.save(updatedCategory);
        return updatedCategory;

    }

    public boolean findById(Long categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
}
