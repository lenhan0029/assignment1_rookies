package com.shoes_store.lenhan.services;

import java.util.List;

import com.shoes_store.lenhan.dto.request.categoryUpdateDTO;
import com.shoes_store.lenhan.dto.response.categoryResponseDTO;
import com.shoes_store.lenhan.model.category;

public interface categoryService {
	
	public List<category> getAllCategories();
	
	public category getCategoryById(Integer id);
	
	public categoryResponseDTO getCategoryDTOById(Integer id);
	
	public categoryResponseDTO createCategory(categoryUpdateDTO category);
	
	public categoryResponseDTO updateCategory(Integer id,categoryUpdateDTO category);
	
	public void deleteCategory(Integer id);
	
}
