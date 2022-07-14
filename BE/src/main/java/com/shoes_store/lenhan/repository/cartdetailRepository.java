package com.shoes_store.lenhan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.cartdetail;
import com.shoes_store.lenhan.model.order;

public interface cartdetailRepository extends JpaRepository<cartdetail, Integer>{

	@Query("select u from cartdetail u where u.cart.id = :cartid")
	List<cartdetail> getByCartId(@Param("cartid") Integer cartid);
	
	@Query("select u from cartdetail u where u.cart.id = :cartid and u.quantitys.id = :quantityid")
	Optional<cartdetail> getByCartIdAndQuantityId(@Param("cartid") Integer cartid,@Param("quantityid") Integer quantityid);
	
	@Modifying
	@Transactional
	@Query("delete from cartdetail p where p.cart.id = :id")
	void deleteCartDetailByCartId(@Param("id") Integer id);
}
