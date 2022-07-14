package com.shoes_store.lenhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.quantity;
import com.shoes_store.lenhan.services.quantityService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/quantity")
public class quantityController {

	private quantityService quantityService;

	@Autowired
	public quantityController(quantityService quantityService) {
		this.quantityService = quantityService;
	}
	
	@GetMapping("/productid={productid}&sizeid={sizeid}")
	public ResponseEntity<?> getQuantity(@PathVariable Integer productid, @PathVariable Integer sizeid){
		quantity quantity = quantityService.findQuantity(productid,sizeid);
		if(quantity == null) {
			throw new ResourceNotFoundException("No quantity");
		}
		return ResponseEntity.ok().body(quantity);
	}
	
	@PutMapping("/productid={productid}&sizeid={sizeid}&qt={qt}")
	public ResponseEntity<?> updateQuantity(@PathVariable Integer productid, @PathVariable Integer sizeid,@PathVariable Integer qt){
		quantity checkQuantity = quantityService.findQuantity(productid,sizeid);
		if(checkQuantity == null) {
			throw new ResourceNotFoundException("No quantity");
		}
		quantity newQuantity = quantityService.updateQuantity(productid,sizeid,qt);
		return ResponseEntity.ok().body(newQuantity);
	}
}
