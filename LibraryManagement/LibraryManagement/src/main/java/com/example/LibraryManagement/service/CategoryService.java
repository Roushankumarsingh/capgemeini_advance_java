package com.example.LibraryManagement.service;

import com.example.LibraryManagement.Entity.Category;
import java.util.*;

public interface CategoryService {
	public void addCategory(Category category);

    public Category getCategoryById(Long id);

    public List<Category> getAllCategories();

    public Category updateCategory(Long id, Category updated);

    public void deleteCategory(Long id);
}
