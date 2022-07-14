package com.shoes_store.lenhan.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.dto.request.orderUpdateDTO;
import com.shoes_store.lenhan.dto.request.productUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.exceptions.productNotFoundException;
import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.model.product;
import com.shoes_store.lenhan.repository.accountRepository;
import com.shoes_store.lenhan.repository.customerRepository;
import com.shoes_store.lenhan.repository.stateRepository;
import com.shoes_store.lenhan.services.orderService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/order")
public class orderController {

	private orderService orderService;
	
	private accountRepository customerRepository;
	
	private stateRepository stateRepository;
	
	private ModelMapper modelmapper;

	@Autowired
	public orderController(orderService orderService,accountRepository customerRepository,stateRepository stateRepository,ModelMapper modelmapper) {
		this.orderService = orderService;
		this.customerRepository=customerRepository;
		this.stateRepository=stateRepository;
		this.modelmapper=modelmapper;
	}
	@GetMapping
	ResponseEntity<?> getAllOrders(){
		return ResponseEntity.ok().body(this.orderService.getAll());
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	ResponseEntity<?> getOrderById(@PathVariable("id") Integer id) {
		order order = this.orderService.getById(id).get();
		if(order == null) {
			throw new productNotFoundException("order with id = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping("/accountid={id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	ResponseEntity<?> getOrderByCustomerId(@PathVariable("id") Integer id) {
		List<order> orders = this.orderService.getByCustomerId(id);
		if(orders.isEmpty()) {
			throw new ResourceNotFoundException("order with customerid = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping("/stateid={id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	ResponseEntity<?> getOrderByStateId(@PathVariable("id") Integer id) {
		List<order> orders = this.orderService.getByStateId(id);
		if(orders.isEmpty()) {
			throw new ResourceNotFoundException("order with stateid = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(orders);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> createOrder(@Valid @RequestBody orderUpdateDTO dto) {
		order order = new order();
		order.setCustomer(this.customerRepository.findById(dto.getCustomerid()).get());
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);
		order.setOrdereddate(date);
		order.setState(this.stateRepository.findById(dto.getStateid()).get());
		return ResponseEntity.ok().body(this.orderService.createOrder(order));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	ResponseEntity<?> updateOrder(@PathVariable("id") Integer id,@RequestBody orderUpdateDTO dto) {
		order order = this.orderService.getById(id).get();
		if(order == null) {
			throw new productNotFoundException("order with id = " + id + "is not exists");
		}
		order.setState(this.stateRepository.findById(dto.getStateid()).get());
		return ResponseEntity.ok().body(this.orderService.updateState(id, order));
	}
}
