package com.shoes_store.lenhan.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoes_store.lenhan.model.brand;

public interface brandRepository extends JpaRepository<brand, Integer>{
	
	@Query("select u from brand u where u.id = :id")
	Optional<brand> findBrandById(@Param("id")Integer id);
	
//	@Modifying
//	@Query("delete from brand u where u.id=:id")
//	void deleteBrand(@Param("id")Integer id);
	
	void deleteById(Integer id);
}
