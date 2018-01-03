package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import com.doitgeek.shoppingbackend.dto.Category;

public interface CategoryDAO {

	// Get single category
	Category get(int id);
	// Get list of categories
	List<Category> list();
	// Add a category
	boolean add(Category category);
	// Delete a category
	boolean delete(Category category);
	// Update category
	boolean update(Category category);
}
