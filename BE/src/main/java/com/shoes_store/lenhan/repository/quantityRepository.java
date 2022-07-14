package com.shoes_store.lenhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.product;
import com.shoes_store.lenhan.model.quantity;
import com.shoes_store.lenhan.model.size;

public interface quantityRepository extends JpaRepository<quantity, Integer>{
//	List<quantity> findByProductAndSize(product product, size size);

//	@Modifying
//	@Transactional
	@Query("select u from quantity u where u.product = :product and u.size= :size")
	quantity findByProductAndSize(@Param("product") product product,@Param("size") size size);
}