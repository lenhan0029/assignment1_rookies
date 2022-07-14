//package com.shoes_store.lenhan.services.impl;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shoes_store.lenhan.dto.request.LoginRequest;
//import com.shoes_store.lenhan.dto.request.SignupRequest;
//import com.shoes_store.lenhan.model.account;
//import com.shoes_store.lenhan.repository.accountRepository;
//import com.shoes_store.lenhan.services.accountService;
//
//@Service
//public class accountServiceImpl implements accountService{
//
//	private accountRepository accountRepository;
//	private ModelMapper modelmapper;
//	
//	@Autowired
//	public accountServiceImpl(com.shoes_store.lenhan.repository.accountRepository accountRepository,
//			ModelMapper modelmapper) {
//		super();
//		this.accountRepository = accountRepository;
//		this.modelmapper = modelmapper;
//	}
//
//
//	@Override
//	public int createAccount(SignupRequest dto) {
//		
//		int savedAccount = accountRepository.insertAccount(dto.getPassword(),dto.getPassword(),3);
//		return savedAccount;
//	}
//
//	
//	@Override
//	public account getAccountByAccount(LoginRequest dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public account UpdateAccount(Integer id, SignupRequest dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
