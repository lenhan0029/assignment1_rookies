package com.shoes_store.lenhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.model.orderdetail;

public interface orderdetailRepository extends JpaRepository<orderdetail, Integer>{

	@Query("select u from orderdetail u where u.order.id = :orderid")
	List<orderdetail> getOrderDetailByOrderId(@Param("orderid") Integer orderid);
}
