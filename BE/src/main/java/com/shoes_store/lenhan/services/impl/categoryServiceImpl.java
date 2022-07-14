package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.dto.request.categoryUpdateDTO;
import com.shoes_store.lenhan.dto.response.categoryResponseDTO;
import com.shoes_store.lenhan.model.category;
import com.shoes_store.lenhan.repository.categoryRepository;
import com.shoes_store.lenhan.services.categoryService;

@Service
public class categoryServiceImpl implements categoryService{

	private categoryRepository categoryrepository;
	private ModelMapper modelmapper;
	
	@Autowired
	public categoryServiceImpl(categoryRepository categoryrepository, ModelMapper modelmapper) {
		this.categoryrepository = categoryrepository;
		this.modelmapper = modelmapper;
	}

	@Override
	public List<category> getAllCategories() {
		return this.categoryrepository.findAll();
	}
	
	@Override
	public category getCategoryById(Integer id) {
		
		Optional<category> categoryoptional = this.categoryrepository.findById(id);
		category category = categoryoptional.get();
		return category;
	}

	@Override
	public categoryResponseDTO getCategoryDTOById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public categoryResponseDTO createCategory(categoryUpdateDTO dto) {
		category category = modelmapper.map(dto, category.class);
		category savedCategory = categoryrepository.save(category);
		return modelmapper.map(savedCategory, categoryResponseDTO.class);
	}

	@Override
	public categoryResponseDTO updateCategory(Integer id, categoryUpdateDTO dto) {

		Optional<category> categoryoptional = categoryrepository.findById(id);
		category category = categoryoptional.get();
		modelmapper.map(dto, category);
		category = categoryrepository.save(category);
		return modelmapper.map(category, categoryResponseDTO.class);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryrepository.deleteById(id);
	}

	

}
