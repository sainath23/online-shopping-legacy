package com.doitgeek.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.dao.CategoryDAO;
import com.doitgeek.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category tv = new Category();
		tv.setId(1);
		tv.setName("Television");
		tv.setDescription("This is a TV Category");
		tv.setImageURL("CAT_1.png");
		categories.add(tv);
		
		Category mobile = new Category();
		mobile.setId(2);
		mobile.setName("Mobile");
		mobile.setDescription("This is a Mobile Category");
		mobile.setImageURL("CAT_2.png");
		categories.add(mobile);
		
		Category laptop = new Category();
		laptop.setId(3);
		laptop.setName("Laptop");
		laptop.setDescription("This is a Laptop Category");
		laptop.setImageURL("CAT_4.png");
		categories.add(laptop);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
