package com.shoes_store.lenhan.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.account;

public interface accountRepository extends JpaRepository<account, Integer>{
//	Optional<account> findByUsername(String username);
	@Query("select t from account t where t.username = :username")
	account findByUsername(@Param("username") String username);
    
    Boolean existsByUsername(String username);
    
    @Modifying
	@Transactional
	@Query(value="insert into accounts (username,password,roleid) values (:username,:password,:roleid)",nativeQuery = true)
	void insertAccount(@Param("username") String username,@Param("password") String passwword,@Param("roleid") Integer roleid);

}
