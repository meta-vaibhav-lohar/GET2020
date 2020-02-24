package com.parking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.LoginDao;
import com.parking.model.LoginDetails;

@Service
public class LoginService {
	
	@Autowired
	LoginDao logindao;
	
	public boolean login(LoginDetails login) {

	
	return	logindao.login(login);
	
	}
}
