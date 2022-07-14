package com.shoes_store.lenhan.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.model.product;

public interface orderRepository extends JpaRepository<order, Integer>{

	@Query("select u from order u where u.account.id = :accountid")
	List<order> getOrderByCustomerId(@Param("accountid") Integer accountid);
	
	@Query("select u from order u where u.state.id = :stateid")
	List<order> getOrderByStateId(@Param("stateid") Integer stateid);
	
//	@Modifying
//	@Transactional
//	@Query("insert into products (productname,categoryid,brandid,price,image,createddate,updateddate,description) values (:productname,:categoryid,:brandid,:price,:image,:createddate,:updateddate,:description)")
//	void insertProduct(@Param("productname") String productname,@Param("categoryid") Integer categoryid,@Param("brandid") Integer brandid,@Param("price") Integer price,@Param("image") String image,@Param("createddate") Date createddate,@Param("updateddate") Date updateddate,@Param("description") String description);

}
