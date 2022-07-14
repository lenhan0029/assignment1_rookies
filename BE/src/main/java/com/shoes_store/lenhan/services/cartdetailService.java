package com.shoes_store.lenhan.services;

import java.util.List;

import com.shoes_store.lenhan.model.cartdetail;

public interface cartdetailService {

	List<cartdetail> getByCartId(Integer id);
	
	cartdetail createCartDetail(cartdetail cartdetail);
	
	cartdetail updateCartDetail(Integer id,cartdetail cartdetail);
	
	void deleteCartDetailById(Integer id);
	
	void deleteCartDetailByCartId(Integer id);
}
