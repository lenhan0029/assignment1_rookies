package com.shoes_store.lenhan.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.product;

public interface productRepository extends JpaRepository<product, Integer>{
	
	@Query("select u from product u left join u.brand ar where ar.id = :brandid")
	List<product> getProductByBrandId(@Param("brandid") Integer brandid);
	
	@Query("SELECT MAX(p.id) FROM product p")
	public Integer MaxId();
	
	@Query("select u from product u where u.productname = :productname")
	product getProductByName(@Param("productname") String productname);
	
//	@Query("select u from product u limit :limit")
//	List<product> getTopProduct(@Param("limit") Integer limit);
	
	@Modifying
	@Transactional
	@Query("delete from product p where p.id = :id")
	Integer deleteProduct(@Param("id") Integer id);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into products (productname,categoryid,brandid,price,image,createddate,updateddate,description) values (:productname,:categoryid,:brandid,:price,:image,:createddate,:updateddate,:description)",nativeQuery = true)
	void insertProduct(@Param("productname") String productname,@Param("categoryid") Integer categoryid,@Param("brandid") Integer brandid,@Param("price") Integer price,@Param("image") String image,@Param("createddate") Date createddate,@Param("updateddate") Date updateddate,@Param("description") String description);
}
