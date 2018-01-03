package com.doitgeek.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doitgeek.onlineshopping.exception.ProductNotFoundException;
import com.doitgeek.shoppingbackend.dao.CategoryDAO;
import com.doitgeek.shoppingbackend.dao.ProductDAO;
import com.doitgeek.shoppingbackend.dto.Category;
import com.doitgeek.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO; // private CategoryDAO categoryDAO = new CategoryDAOImpl();
	@Autowired
	private ProductDAO productDAO; // private ProductDAO productDAO = new ProductDAOImpl();
	private ModelAndView mv;
	
	/*
	 * Every request from /,/home and /index will be handled by index() method.
	 */
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Method to load all products
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	/*
	 * Method to load all products based on category
	 */
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/*
	 * Method to show single product
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int productId) throws ProductNotFoundException {
		mv = new ModelAndView("page");
		Product product = productDAO.get(productId);
		
		if(product == null)
			throw new ProductNotFoundException();
		
		// Incrementing view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
}
