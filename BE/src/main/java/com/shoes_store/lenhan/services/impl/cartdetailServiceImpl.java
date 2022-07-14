package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.model.cartdetail;
import com.shoes_store.lenhan.repository.cartdetailRepository;
import com.shoes_store.lenhan.services.cartdetailService;

@Service
public class cartdetailServiceImpl implements cartdetailService{

	private cartdetailRepository cartdetailRepository;
	
	@Autowired
	public cartdetailServiceImpl(cartdetailRepository cartdetailRepository) {
		this.cartdetailRepository = cartdetailRepository;
	}

	@Override
	public List<cartdetail> getByCartId(Integer id) {
		return this.cartdetailRepository.getByCartId(id);
	}

	@Override
	public cartdetail createCartDetail(cartdetail cartdetail) {
		return this.cartdetailRepository.save(cartdetail);
	}

	@Override
	public cartdetail updateCartDetail(Integer id, cartdetail cartdetail) {
		Optional<cartdetail> item = this.cartdetailRepository.findById(id);
		Optional<cartdetail> itemcheckloop = this.cartdetailRepository.getByCartIdAndQuantityId(cartdetail.getCart().getId(), cartdetail.getQuantitys().getId());
		if(itemcheckloop.isPresent()) {
			Integer newQuantity = cartdetail.getQuantity();
			cartdetail itemloop = itemcheckloop.get();
			itemloop.setQuantity(newQuantity);
			
			return this.cartdetailRepository.save(itemloop);
		}
		cartdetail itemupdate = item.get();
		itemupdate.setQuantity(cartdetail.getQuantity());
		return this.cartdetailRepository.save(itemupdate);
	}

	@Override
	public void deleteCartDetailById(Integer id) {
		this.cartdetailRepository.deleteById(id);;
	}

	@Override
	public void deleteCartDetailByCartId(Integer id) {
		// TODO Auto-generated method stub
		this.cartdetailRepository.deleteCartDetailByCartId(id);
	}	
}
