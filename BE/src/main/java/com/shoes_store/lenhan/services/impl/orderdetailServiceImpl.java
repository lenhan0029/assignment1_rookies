package com.shoes_store.lenhan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.model.orderdetail;
import com.shoes_store.lenhan.repository.orderdetailRepository;
import com.shoes_store.lenhan.services.orderdetailService;

@Service
public class orderdetailServiceImpl implements orderdetailService{

	private orderdetailRepository orderdetailRepository;
	
	@Autowired
	public orderdetailServiceImpl(orderdetailRepository orderdetailRepository) {
		this.orderdetailRepository = orderdetailRepository;
	}
	@Override
	public List<orderdetail> getOrderDetailByOrderId(Integer id) {
		return this.orderdetailRepository.getOrderDetailByOrderId(id);
	}
	@Override
	public orderdetail createOrderDetail(orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return this.orderdetailRepository.save(orderdetail);
	}

}
