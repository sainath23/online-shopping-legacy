package com.doitgeek.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doitgeek.shoppingbackend.dao.CategoryDAO;
import com.doitgeek.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.doitgeek.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is a description for Laptop.");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully added Laptop category!", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully fetch mobile category!", "Mobile", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(2);
		category.setName("Mobile Phone");
		assertEquals("Successfully updated category!", true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted category!", true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		assertEquals("Successfully fetch list of categories!", 2, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		// Testing add()
		category = new Category();
		category.setName("Televsion");
		category.setDescription("This is a description for Television.");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added TV category!", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is a description for Mobile.");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added Mobile category!", true, categoryDAO.add(category));
		
		// Testing get()
		category = categoryDAO.get(2);
		assertEquals("Successfully fetch mobile category!", "Mobile", category.getName());
		
		// Testing update()
		category.setName("Mobile Phone");
		assertEquals("Successfully updated category!", true, categoryDAO.update(category));
		
		// Testing delete()
		assertEquals("Successfully deleted category!", true, categoryDAO.delete(category));
		
		// Testing list()
		assertEquals("Successfully fetch list of categories!", 1, categoryDAO.list().size());
	}
}
