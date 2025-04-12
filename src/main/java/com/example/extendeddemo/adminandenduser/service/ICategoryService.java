package com.example.extendeddemo.adminandenduser.service;

import java.util.List;

import com.example.extendeddemo.admin.model.Categories;

public interface ICategoryService {
	//field
	
			
	// method
	public Categories getCategory(long id);
	
	public List<Categories> getAllCategories();
	
	/**
	 * Method desc
	 * @param param1 Param desc
	 * @return return desc
	 */
	public void saveCategory(Categories object);
	
	public void updateCategory(Categories object);
	
	public void deleteCategory(long id);

}
