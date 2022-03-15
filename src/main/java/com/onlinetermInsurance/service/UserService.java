package com.onlinetermInsurance.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.exception.ResourceNotFoundException;



public interface UserService {
	public List<User> getAllUsers();
	public User findUserById(Integer userid) throws ResourceNotFoundException;
	public boolean deleteUser(User user)throws ResourceNotFoundException;
	public User saveUser(User user) throws ValidationException;
	public User updateUser(Integer userid,User user)throws ResourceNotFoundException;

}
