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

import com.shoes_store.lenhan.dto.request.productUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.exceptions.productNotFoundException;
import com.shoes_store.lenhan.model.product;
import com.shoes_store.lenhan.repository.productRepository;
import com.shoes_store.lenhan.services.productService;


@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/product")
public class productController {

	private productService productservice;
	
	private productRepository pr;
	
	@Autowired
	public productController(productService productservice, productRepository pr) {
		super();
		this.productservice = productservice;
		this.pr=pr;
	}
	@GetMapping
	ResponseEntity<?> getAllProducts(){
		return ResponseEntity.ok().body(this.productservice.getAllProduct());
	}
	@GetMapping("/{id}")
	ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
		product product = this.productservice.getProductById(id);
		if(product == null) {
			throw new productNotFoundException("product with id = " + id + "is not exists");
		}
		
		return ResponseEntity.ok().body(this.productservice.getProductById(id));
	}
	
	@GetMapping("/brand={id}")
	ResponseEntity<?> getProductByBrandId(@PathVariable("id") Integer id) {
		List<product> productlist = this.productservice.getProductByBrandId(id);
		if(productlist.isEmpty()) {
			throw new productNotFoundException("product with brand id = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(this.productservice.getProductByBrandId(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> createProduct(@Valid @RequestBody productUpdateDTO dto) {
		return ResponseEntity.ok().body(this.productservice.createProduct(dto));
	}
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,@RequestBody productUpdateDTO dto) {
		product product = this.productservice.getProductById(id);
		if(product == null) {
			throw new productNotFoundException("product with id = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(this.productservice.updateProduct(id, dto));
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id){
		product product = this.productservice.getProductById(id);
		if(product == null) {
			throw new productNotFoundException("product with id = " + id + "is not exists");
		}
		Integer result = this.productservice.deleteProduct(id);
		if(result > 0)
			return  ResponseEntity.ok().body("Delete product with id=" + id + "success");
		throw new ResourceNotFoundException("can't delete product with id=" + id);
	}
	
}
