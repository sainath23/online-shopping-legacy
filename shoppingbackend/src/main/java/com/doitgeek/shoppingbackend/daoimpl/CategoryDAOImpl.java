package com.doitgeek.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doitgeek.shoppingbackend.dao.CategoryDAO;
import com.doitgeek.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();
	
	/*static {
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
	}*/

	@Override
	public List<Category> list() {
		// return categories;
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * Getting single category based on id.
	 * @see com.doitgeek.shoppingbackend.dao.CategoryDAO#get(int)
	 */
	@Override
	public Category get(int id) {
		/*for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}*/
		//return null;
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Update single category
	 * @see com.doitgeek.shoppingbackend.dao.CategoryDAO#update(com.doitgeek.shoppingbackend.dto.Category)
	 */
	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
