package com.service;

import com.service_implimentation.loginHandler_implimentation;

import Entites.Registation;

public interface LoginHandler {
	
	boolean check_idexit(long id);
	boolean check_emailExit(String email);
    
	
	String Name_conneted_with_id(long id);
	Registation getEmployeeById(long id);
	boolean check_Employe_password(long id, String password);
	
//	login
	boolean authicate (String username ,String password);
	long get_id(String username ,String password);
	
	
}

