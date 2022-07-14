package com.shoes_store.lenhan.services;

import java.util.List;
import java.util.Optional;

import com.shoes_store.lenhan.dto.request.orderUpdateDTO;
import com.shoes_store.lenhan.dto.response.orderResponseDTO;
import com.shoes_store.lenhan.model.order;

public interface orderService {

	List<order> getAll();
	
	Optional<order> getById(Integer id);
	
	List<order> getByCustomerId(Integer id);
	
	List<order> getByStateId(Integer id);
	
	order createOrder(order order);
	
	order updateState(Integer id, order order);
}
