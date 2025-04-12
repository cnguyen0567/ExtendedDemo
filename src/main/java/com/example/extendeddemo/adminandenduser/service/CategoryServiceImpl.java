package com.example.extendeddemo.adminandenduser.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.extendeddemo.admin.model.Categories;
import com.example.extendeddemo.adminandenduser.dao.CategoryDAOImpl;
import com.example.extendeddemo.adminandenduser.dao.ICategoryDAO;

public class CategoryServiceImpl implements ICategoryService {
	
	//this is instantiating a class using interface reference
	private ICategoryDAO dao;
	//can't use until springboot private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);
	
	public CategoryServiceImpl() {    //instantiate the field inside the constructure ensures that 
		dao = new CategoryDAOImpl();  // when this class is called/used , the field will be instantize
	}

	@Override
	public Categories getCategory(long id) {
		// TODO Auto-generated method stub
		Categories returnedCategory = dao.get(id);  //or just return dao.get(id);
		return returnedCategory;
	}

	@Override
	public List<Categories> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCategory(Categories object) {
		// TODO Auto-generated method stub
		System.out.println("Inside CategoriesServiceImpl.saveCategory()");
		dao.save(object);

	}

	@Override
	public void updateCategory(Categories object) {
		// TODO Auto-generated method stub
		System.out.println("Inside CategoriesServiceImpl.updateCategory()");
		dao.update(object);
		
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		
	}

}
