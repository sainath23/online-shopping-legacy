package com.doitgeek.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doitgeek.shoppingbackend.dao.ProductDAO;
import com.doitgeek.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.doitgeek.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void testProductCRUD() {
		// Test add()
		product = new Product();
		product.setName("Oneplus 5");
		product.setBrand("Oneplus");
		product.setDescription("Flagship killer 2017");
		product.setUnitPrice(33000);
		product.setQuantity(10);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		product.setPurchases(2);
		product.setViews(5);
		
		assertEquals("Something went wrong while inserting a product", true, productDAO.add(product));
		
		// Test get()
		product = productDAO.get(8);
		assertEquals("Something went wrong while fetching a product", "Oneplus 5", product.getName());
		
		// Test update()
		product.setName("OnePlus 5");
		assertEquals("Something went wrong while updating a product", true, productDAO.update(product));
		
		// Test delete()
		assertEquals("Something went wrong while deleting a product", true, productDAO.delete(product));
		
		// Test list()
		assertEquals("Something went wrong while counting list of product", 6, productDAO.list().size());
	}*/
	
	@Test
	public void testBusinessMethods() {
		assertEquals("Something went wrong while listActiveProducts", 5, productDAO.listActiveProducts().size());
		assertEquals("Something went wrong while listActiveProductsByCategory", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while getLatestActiveProducts", 4, productDAO.getLatestActiveProducts(4).size());
	}
}
