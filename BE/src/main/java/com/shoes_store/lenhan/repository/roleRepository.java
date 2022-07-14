package com.shoes_store.lenhan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nashtech.rookies.model.Role;
import com.nashtech.rookies.model.RoleName;
import com.shoes_store.lenhan.model.role;


public interface roleRepository extends JpaRepository<role, Integer>{
//	@Query("select u from brand u where u.role = :role")
//	Optional<role> findByName(@Param("role") String role);
//	Optional<Role> findByName(RoleName roleName);
}
