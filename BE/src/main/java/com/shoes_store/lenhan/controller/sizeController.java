package com.shoes_store.lenhan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.brand;
import com.shoes_store.lenhan.model.size;
import com.shoes_store.lenhan.services.sizeService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/size")
public class sizeController {

	private sizeService sizeService;

	@Autowired
	public sizeController(sizeService sizeService) {
		this.sizeService = sizeService;
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBrands(){
		List<size> sizes = sizeService.getAll();
		if(sizes.isEmpty()) {
			throw new ResourceNotFoundException("Size is empty");
		}
		return ResponseEntity.ok().body(sizes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSizeById(@PathVariable("id") Integer id) {
		Optional<size> size = sizeService.getById(id);
		if(size.isEmpty()) {
			throw new ResourceNotFoundException("Size with id=" + id + "is not exits");
		}
		return ResponseEntity.ok().body(size);
	}
	
	
}
