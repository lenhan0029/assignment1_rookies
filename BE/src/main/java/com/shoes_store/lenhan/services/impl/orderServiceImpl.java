package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.dto.request.orderUpdateDTO;
import com.shoes_store.lenhan.dto.response.orderResponseDTO;
import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.repository.orderRepository;
import com.shoes_store.lenhan.services.orderService;

@Service
public class orderServiceImpl implements orderService{

	private orderRepository orderRepository;
	private ModelMapper modelmapper;
	@Autowired
	public orderServiceImpl(orderRepository orderRepository, ModelMapper modelmapper) {
		this.orderRepository = orderRepository;
		this.modelmapper = modelmapper;
	}
	
	@Override
	public List<order> getAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Optional<order> getById(Integer id) {
		return this.orderRepository.findById(id);
	}

	@Override
	public List<order> getByCustomerId(Integer id) {
		return this.orderRepository.getOrderByCustomerId(id);
	}

	@Override
	public List<order> getByStateId(Integer id) {
		return this.orderRepository.getOrderByStateId(id);
	}

	@Override
	public order createOrder(order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public order updateState(Integer id, order order) {
		order newOrder = this.orderRepository.findById(id).get();
		newOrder.setState(order.getState());
		return newOrder;
	}


	


}
