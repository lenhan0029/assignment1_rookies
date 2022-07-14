package com.shoes_store.lenhan.controller;

import java.util.List;
import java.util.Optional;

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


import com.shoes_store.lenhan.dto.request.brandUpdateDTO;
import com.shoes_store.lenhan.dto.response.brandResponseDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.brand;
import com.shoes_store.lenhan.services.brandService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/brand")
public class brandController {
	private brandService brandservice;
	
	@Autowired
	public brandController(brandService brandservice) {
		this.brandservice = brandservice;
	}


	@GetMapping
	public ResponseEntity<?> getAllBrands(){
		List<brand> brands = brandservice.getAllBrand();
		if(brands.isEmpty()) {
			throw new ResourceNotFoundException("Brand is empty");
		}
		return ResponseEntity.ok().body(this.brandservice.getAllBrand());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBrandById(@PathVariable("id") Integer id) {
		Optional<brand> brand = this.brandservice.getBrandById(id);
		if(brand.isEmpty()) {
			throw new ResourceNotFoundException("Brand with id=" + id + "is not exits");
		}
		return ResponseEntity.ok().body(brand);
	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<?> createBrand(@Valid @RequestBody brandUpdateDTO dto) {
//		return ResponseEntity.ok().body(this.brandservice.createBrand(dto));
//	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	public brandResponseDTO createBrand(@Valid @RequestBody brandUpdateDTO dto) {
		return this.brandservice.createBrand(dto);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer id,@RequestBody brandUpdateDTO dto) {
		Optional<brand> brand = this.brandservice.getBrandById(id);
		if(brand.isEmpty()) {
			throw new ResourceNotFoundException("Brand with id=" + id + "is not exits");
		}
		return ResponseEntity.ok().body(this.brandservice.updateBrand(id, dto));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteBrand(@PathVariable("id") Integer id) {
		Optional<brand> brand = this.brandservice.getBrandById(id);
		if(brand.isEmpty()) {
			throw new ResourceNotFoundException("Brand with id=" + id + "is not exits");
		}
		this.brandservice.deleteBrand(id);
		return ResponseEntity.ok().body("Brand with id=" + id + "is  deleted");
	}
	
}
