package com.shoes_store.lenhan.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes_store.lenhan.dto.request.brandUpdateDTO;
import com.shoes_store.lenhan.dto.response.brandResponseDTO;
import com.shoes_store.lenhan.model.brand;
import com.shoes_store.lenhan.repository.brandRepository;
import com.shoes_store.lenhan.services.brandService;


@Service
public class brandServiceImpl implements brandService{
	
	private brandRepository brandrepository;
	private ModelMapper modelmapper;
	
	@Autowired
	public brandServiceImpl(brandRepository brandrepository, ModelMapper modelmapper) {
		this.brandrepository = brandrepository;
		this.modelmapper = modelmapper;
	}
	
	@Override
	public List<brand> getAllBrand(){
		return this.brandrepository.findAll();
	}

	@Override
	public Optional<brand> getBrandById(Integer id) {
		Optional<brand> brandoptional = brandrepository.findBrandById(id);
		return brandoptional;
	}

	@Override
	public brandResponseDTO getBrandDTOById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public brandResponseDTO createBrand(brandUpdateDTO dto) {
		brand brand = modelmapper.map(dto, brand.class);
		brand savedBrand = brandrepository.save(brand);
		return modelmapper.map(savedBrand, brandResponseDTO.class);
	}

	@Override
	public brandResponseDTO updateBrand(Integer id, brandUpdateDTO dto) {
		Optional<brand> brandoptional = brandrepository.findById(id);
		brand brand = brandoptional.get();
		modelmapper.map(dto, brand);
		brand = brandrepository.save(brand);
		return modelmapper.map(brand, brandResponseDTO.class);
	}
	@Override
	public void deleteBrand(Integer id) {
		brandrepository.deleteById(id);
	}

	
}
