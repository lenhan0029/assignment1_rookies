package com.shoes_store.lenhan.services;

import java.util.List;

import com.shoes_store.lenhan.dto.request.productUpdateDTO;
import com.shoes_store.lenhan.dto.response.productResponseDTO;
import com.shoes_store.lenhan.model.product;


public interface productService {
	public List<product> getAllProduct();
	
	public product getProductById(Integer id);
	
//	public product getProductByName(String productname);
	
	public List<product> getProductByBrandId(Integer id);
	
//	public List<product> getTopProduct(Integer id);
	
	public productResponseDTO getProductDTOById(Integer id);
	
	public product createProduct(productUpdateDTO dto);
	
	public productResponseDTO updateProduct(Integer id,productUpdateDTO dto);
	
	public Integer deleteProduct(Integer id);
}
