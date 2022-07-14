package com.shoes_store.lenhan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoes_store.lenhan.model.size;

public interface sizeRepository extends JpaRepository<size, Integer>{

	Optional<size> findById(Integer id);
	
	
}
