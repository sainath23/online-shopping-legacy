package com.doitgeek.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doitgeek.shoppingbackend.dao.ProductDAO;
import com.doitgeek.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping(value = "/category/{id}/products")
	@ResponseBody
	public List<Product> getCategoryProducts(@PathVariable("id") int categoryId) {
		return productDAO.listActiveProductsByCategory(categoryId);
	}
}
