package com.onlinetermInsurance.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.onlinetermInsurance.entity.Login;
import com.onlinetermInsurance.exception.ResourceNotFoundException;

public interface LoginService1 {

	public Login addUserCredentials(Login l) throws ValidationException, ResourceNotFoundException;

	public String deleteUserCredentials(String username, String password) throws ValidationException, ResourceNotFoundException;

	public String updateUserCredentials(String username, String password) throws ResourceNotFoundException;

	public List<Login> getAllUserCredentials();
	
}
