package com.shoes_store.lenhan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.product;
import com.shoes_store.lenhan.model.quantity;
import com.shoes_store.lenhan.model.size;
import com.shoes_store.lenhan.repository.productRepository;
import com.shoes_store.lenhan.repository.quantityRepository;
import com.shoes_store.lenhan.repository.sizeRepository;
import com.shoes_store.lenhan.services.quantityService;

@Service
public class quantityServiceImpl implements quantityService{


	private final quantityRepository quantityRepository;
	private final productRepository productRepository;
	private final sizeRepository sizeRepository;
	@Autowired
	public quantityServiceImpl(com.shoes_store.lenhan.repository.quantityRepository quantityRepository,
			com.shoes_store.lenhan.repository.productRepository productRepository,
			com.shoes_store.lenhan.repository.sizeRepository sizeRepository) {
		super();
		this.quantityRepository = quantityRepository;
		this.productRepository = productRepository;
		this.sizeRepository = sizeRepository;
	}

	@Override
	@Transactional
	public quantity findQuantity(Integer productid, Integer sizeid) {
		product product = productRepository.findById(productid).get();
		size size = sizeRepository.findById(sizeid).get();
		quantity quantity = quantityRepository.findByProductAndSize(product, size);
		return quantity;
	}

	
	@Override
	@Transactional
	public quantity updateQuantity(Integer productid, Integer sizeid, Integer quantity) {
		product product = productRepository.findById(productid).get();
		size size = sizeRepository.findById(sizeid).get();
		quantity updateQuantity = quantityRepository.findByProductAndSize(product, size);
		Integer oldQuantity=updateQuantity.getQuantity();
		oldQuantity=quantity;
		quantity newQuantity = new quantity(updateQuantity.getId(),product,size,oldQuantity);
		quantity result = quantityRepository.save(newQuantity);
		return result;
	}

}
