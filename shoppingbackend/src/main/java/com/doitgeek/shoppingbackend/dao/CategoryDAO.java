package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import com.doitgeek.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
