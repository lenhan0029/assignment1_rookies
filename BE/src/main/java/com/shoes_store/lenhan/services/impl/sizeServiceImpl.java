package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.model.size;
import com.shoes_store.lenhan.repository.sizeRepository;
import com.shoes_store.lenhan.services.sizeService;

@Service
public class sizeServiceImpl implements sizeService{

	private sizeRepository sizeRepository;
	@Autowired
	public sizeServiceImpl(sizeRepository sizeRepository) {
		this.sizeRepository = sizeRepository;
	}
	
	@Override
	public List<size> getAll() {
		return this.sizeRepository.findAll();
	}


	@Override
	public Optional<size> getById(Integer id) {
		return this.sizeRepository.findById(id);
	}

	
}
