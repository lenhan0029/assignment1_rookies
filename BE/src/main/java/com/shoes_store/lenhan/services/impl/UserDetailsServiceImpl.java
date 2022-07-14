package com.shoes_store.lenhan.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_store.lenhan.model.account;
import com.shoes_store.lenhan.repository.accountRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final accountRepository userRepository;

    public UserDetailsServiceImpl (accountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

    	account user = userRepository.findByUsername(username);
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("User Not Found with -> username : " + username)
//                );

        return UserDetailsImpl.build(user);
    }
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//    	//
//    	// user name lúc login là "usename encode(password)"
//    	String[] thongtin = username.split(" "); // index 0: username 1: password
//    	Optional<account> optional = userRepository.findByUsername(thongtin[0]);
////    	if(!optional.isPresent()) {
////    		throw new UnauthorizedException("Username is not found");
////    	}
//        account user = optional.get();
////        if(thongtin.length > 1 && !BCrypt.checkpw(thongtin[1],user.getPassword())) {
////        	throw new UnauthorizedException("Password is wrong");
////        }
//        return UserDetailsImpl.build(user);
//    }
}
