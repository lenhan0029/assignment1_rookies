package com.shoes_store.lenhan.controller;

import java.util.List;
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

import com.shoes_store.lenhan.dto.request.cartUpdateDTO;
import com.shoes_store.lenhan.exceptions.ResourceNotFoundException;
import com.shoes_store.lenhan.model.cart;
import com.shoes_store.lenhan.repository.accountRepository;
import com.shoes_store.lenhan.services.cartService;

@RestController
@CrossOrigin(origins="*", maxAge= 3600)
@RequestMapping("/cart")
public class cartController {

	private cartService cartService;
	
	private accountRepository accountRepository;

	@Autowired
	public cartController(cartService cartService,accountRepository accountRepository) {
		this.cartService = cartService;
		this.accountRepository = accountRepository;
	}
	
	@GetMapping("/accountid={id}")
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> getCartByAccountId(@PathVariable("id") Integer id) {
		Optional<cart> carts = this.cartService.getCartByAccountId(id);
		if(carts.isEmpty()) {
			throw new ResourceNotFoundException("cart with account id = " + id + "is not exists");
		}
		return ResponseEntity.ok().body(carts);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('USER')")
	ResponseEntity<?> createCart(@Valid @RequestBody cartUpdateDTO dto) {
		Optional<cart> carts = this.cartService.getCartByAccountId(dto.getAccountid());
		if(carts.isPresent()) {
			return ResponseEntity.ok().body(carts);
		}
		cart cart = new cart();
		cart.setAccount(this.accountRepository.findById(dto.getAccountid()).get());
		return ResponseEntity.ok().body(this.cartService.createCart(cart));
	}
}
