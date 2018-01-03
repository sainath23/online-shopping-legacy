package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import com.doitgeek.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean delete(Product product);
	boolean update(Product product);
	
	// Business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
