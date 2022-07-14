package com.shoes_store.lenhan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoes_store.lenhan.model.cart;

public interface cartRepository extends JpaRepository<cart, Integer>{
	
	@Query("select u from cart u where u.account.id = :accountid")
	Optional<cart> getCartByCustomerId(@Param("accountid") Integer accountid);
}
