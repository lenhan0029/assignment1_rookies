package com.shoes_store.lenhan.controller;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.dto.request.orderUpdateDTO;
import com.shoes_store.lenhan.dto.request.orderdetailUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.model.orderdetail;
import com.shoes_store.lenhan.repository.orderRepository;
import com.shoes_store.lenhan.repository.quantityRepository;
import com.shoes_store.lenhan.services.orderdetailService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/orderdetail")
public class orderdetailController {

	private orderdetailService orderdetailService;
	
	private orderRepository orderRepository;
	
	private quantityRepository quantityRepository;

	@Autowired
	public orderdetailController(orderdetailService orderdetailService,
			orderRepository orderRepository,quantityRepository quantityRepository) {
		this.orderdetailService = orderdetailService;
		this.orderRepository = orderRepository;
		this.quantityRepository=quantityRepository;
	}
	
	@GetMapping("/orderid={id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	ResponseEntity<?> getOrderDetailByOrderId(@PathVariable("id") Integer id) {
		Optional<order> orders = this.orderRepository.findById(id);
		if(orders.isEmpty()) {
			throw new ResourceNotFoundException("order with id = " + id + "is not exists");
		}
		List<orderdetail> orderdetails = this.orderdetailService.getOrderDetailByOrderId(id);
		if(orderdetails.isEmpty()) {
			throw new ResourceNotFoundException("orderdetail with orderid = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(orderdetails);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> createOrderDetail(@Valid @RequestBody List<orderdetailUpdateDTO> list) {
		ListIterator<orderdetailUpdateDTO> itr = list.listIterator();
		while (itr.hasNext()) {
			orderdetailUpdateDTO dto = itr.next();
		Optional<order> order = this.orderRepository.findById(dto.getOrderid());
		if(order.isEmpty()) {
			throw new ResourceNotFoundException("order with id = " + dto.getOrderid() + "is not exists");
		}
		orderdetail orderdetail = new orderdetail();
		orderdetail.setOrder(this.orderRepository.findById(dto.getOrderid()).get());
		orderdetail.setQuantitys(this.quantityRepository.findById(dto.getQuantityid()).get());
		orderdetail.setQuantity(dto.getQuantity());
		this.orderdetailService.createOrderDetail(orderdetail);
		}
		return ResponseEntity.ok().body("add order detail success");
	}
	
}
