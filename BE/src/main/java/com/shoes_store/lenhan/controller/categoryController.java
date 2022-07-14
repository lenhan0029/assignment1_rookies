package com.shoes_store.lenhan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.dto.request.categoryUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.category;
import com.shoes_store.lenhan.services.categoryService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/category")
public class categoryController {
	
	private categoryService categoryservice;
	
	@Autowired
	public categoryController(categoryService categoryservice) {
		this.categoryservice = categoryservice;
	}


	@GetMapping
	public ResponseEntity<?> getAllCategorys(){
		List<category> categories = this.categoryservice.getAllCategories();
		if(categories.isEmpty()) {
			throw new ResourceNotFoundException("No category existing");
		}
		return ResponseEntity.ok().body(this.categoryservice.getAllCategories());
	}
	@GetMapping("/{id}")
	ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
		category category = this.categoryservice.getCategoryById(id);
		if(category == null) {
			throw new ResourceNotFoundException("No category with id=" + id);
		}
		return ResponseEntity.ok().body(this.categoryservice.getCategoryById(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> createCategory(@Valid @RequestBody categoryUpdateDTO dto) {
		return ResponseEntity.ok().body(this.categoryservice.createCategory(dto));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> updateCategory(@PathVariable("id") Integer id,@RequestBody categoryUpdateDTO dto) {
		category category = this.categoryservice.getCategoryById(id);
		if(category == null) {
			throw new ResourceNotFoundException("No category with id=" + id);
		}
		return ResponseEntity.ok().body(this.categoryservice.updateCategory(id, dto));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		category category = this.categoryservice.getCategoryById(id);
		if(category == null) {
			throw new ResourceNotFoundException("No category with id=" + id);
		}
		this.categoryservice.deleteCategory(id);
		return ResponseEntity.ok().body("Category with id=" + id + "is  deleted");
	}
	
}
