package com.shoes_store.lenhan.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.model.quantity;

@Component
public interface quantityService {

	public quantity findQuantity(Integer productid, Integer sizeid);
	
	public quantity updateQuantity(Integer productid, Integer sizeid,Integer quantity);
}
