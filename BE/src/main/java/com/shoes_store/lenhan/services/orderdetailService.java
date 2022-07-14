package com.shoes_store.lenhan.services;

import java.util.List;

import com.shoes_store.lenhan.model.orderdetail;

public interface orderdetailService {

	List<orderdetail> getOrderDetailByOrderId(Integer id);
	
	orderdetail createOrderDetail(orderdetail orderdetail);
}
