package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.dto.request.cartUpdateDTO;
import com.shoes_store.lenhan.model.cart;
import com.shoes_store.lenhan.repository.cartRepository;
import com.shoes_store.lenhan.services.cartService;

@Service
public class cartServiceImpl implements cartService{

	private cartRepository cartRepository;
	@Autowired
	public cartServiceImpl(cartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public List<cart> getAll() {
		return this.cartRepository.findAll();
	}

	@Override
	public Optional<cart> getCartById(Integer id) {
		return this.cartRepository.findById(id);
	}

	@Override
	public Optional<cart> getCartByAccountId(Integer id) {
		return this.cartRepository.getCartByCustomerId(id);
	}

	@Override
	public cart createCart(cart cart) {
		return this.cartRepository.save(cart);
	}



}
