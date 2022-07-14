package com.shoes_store.lenhan.services;

import java.util.List;
import java.util.Optional;

import com.shoes_store.lenhan.model.size;

public interface sizeService {

	List<size> getAll();
	
	Optional<size> getById(Integer id);
}
