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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoes_store.lenhan.dto.request.cartdetailUpdateDTO;
import com.shoes_store.lenhan.dto.request.orderdetailUpdateDTO;
import com.shoes_store.lenhan.dto.request.productUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.exceptions.productNotFoundException;
import com.shoes_store.lenhan.model.cart;
import com.shoes_store.lenhan.model.cartdetail;
import com.shoes_store.lenhan.model.order;
import com.shoes_store.lenhan.model.orderdetail;
import com.shoes_store.lenhan.model.product;
import com.shoes_store.lenhan.repository.cartRepository;
import com.shoes_store.lenhan.repository.cartdetailRepository;
import com.shoes_store.lenhan.repository.quantityRepository;
import com.shoes_store.lenhan.services.cartdetailService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/cartdetail")
public class cartdetailController {

	private cartdetailService cartdetailService;
	private cartdetailRepository cartdetailRepository;
	private cartRepository cartRepository;
	private quantityRepository quantityRepository;

	@Autowired
	public cartdetailController(cartdetailService cartdetailService,cartRepository cartRepository,
			quantityRepository quantityRepository,cartdetailRepository cartdetailRepository) {
		this.cartdetailService = cartdetailService;
		this.cartRepository=cartRepository;
		this.quantityRepository=quantityRepository;
		this.cartdetailRepository=cartdetailRepository;
	}
	
	@GetMapping("/cartid={id}")
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> getCartDetailByCartId(@PathVariable("id") Integer id) {
		Optional<cart> carts = this.cartRepository.findById(id);
		if(carts.isEmpty()) {
			throw new ResourceNotFoundException("cart with id = " + id + "is not exists");
		}
		List<cartdetail> cartdetails = this.cartdetailService.getByCartId(id);
		if(cartdetails.isEmpty()) {
			throw new ResourceNotFoundException("cartdetail with cartid = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(cartdetails);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> createCartDetail(@Valid @RequestBody List<cartdetailUpdateDTO> list) {
		ListIterator<cartdetailUpdateDTO> itr = list.listIterator();
		while (itr.hasNext()) {
			cartdetailUpdateDTO dto = itr.next();
		Optional<cart> cart = this.cartRepository.findById(dto.getCartid());
		if(cart.isEmpty()) {
			throw new ResourceNotFoundException("cart with id = " + dto.getCartid() + "is not exists");
		}
		cartdetail cartdetail = new cartdetail();
		cartdetail.setCart(this.cartRepository.findById(dto.getCartid()).get());
		cartdetail.setQuantitys(this.quantityRepository.findById(dto.getQuantityid()).get());
		cartdetail.setQuantity(dto.getQuantity());
		this.cartdetailService.createCartDetail(cartdetail);
		}
		return ResponseEntity.ok().body("add cart detail success");
	}
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> updateCartDetail(@PathVariable("id") Integer id,@RequestBody cartdetailUpdateDTO dto) {
		Optional<cartdetail> checkcartdetail = this.cartdetailRepository.findById(id);
		if(checkcartdetail.isEmpty()) {
			throw new ResourceNotFoundException("cartdetail with id = " + id + "is not exists");
		}
		cartdetail cartdetail = new cartdetail();
		cartdetail.setCart(this.cartRepository.findById(dto.getCartid()).get());
		cartdetail.setQuantitys(this.quantityRepository.findById(dto.getQuantityid()).get());
		cartdetail.setQuantity(dto.getQuantity());
		return ResponseEntity.ok().body(this.cartdetailService.updateCartDetail(id, cartdetail));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> deleteCartDetailById(@PathVariable("id") Integer id){
		Optional<cartdetail> checkcartdetail = this.cartdetailRepository.findById(id);
		if(checkcartdetail.isEmpty()) {
			throw new ResourceNotFoundException("cartdetail with id = " + id + "is not exists");
		}
		this.cartdetailService.deleteCartDetailById(id);
		Optional<cartdetail> check = this.cartdetailRepository.findById(id);
		if(check.isEmpty()) {
			return ResponseEntity.ok().body(" delete cartdetail with id = " + id + "success");
		}
		return ResponseEntity.ok().body(" delete cartdetail with id = " + id + "fail");
	}
	
	@DeleteMapping("/cartid={id}")
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> deleteCartDetailByCartId(@PathVariable("id") Integer id){
		List<cartdetail> checkcartdetail = this.cartdetailRepository.getByCartId(id);
		if(checkcartdetail.isEmpty()) {
			throw new ResourceNotFoundException("cartdetail with cartid = " + id + "is not exists");
		}
		this.cartdetailService.deleteCartDetailByCartId(id);
		List<cartdetail> check = this.cartdetailRepository.getByCartId(id);
		if(checkcartdetail.isEmpty()) {
			return ResponseEntity.ok().body(" delete cartdetail with cartid = " + id + "success");
		}
		return ResponseEntity.ok().body(" delete cartdetail with cartid = " + id + "fail");
	}
}
