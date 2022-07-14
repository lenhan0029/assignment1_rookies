package com.shoes_store.lenhan.services;

import java.util.List;
import java.util.Optional;

import com.shoes_store.lenhan.model.cart;

public interface cartService {

	List<cart> getAll();
	
	Optional<cart> getCartById(Integer id);
	
	Optional<cart> getCartByAccountId(Integer id);
	
	cart createCart(cart cart);
	
}
