package com.onlinetermInsurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetermInsurance.entity.Policy;
import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@Api(description="User Controller class for all url based function")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/user")
	@ApiOperation(value="Get all User details")
	public List<User> getAllUsers() {
		logger.info("Get all User Details");
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value="Get all User detail by using user Id")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userid) throws ResourceNotFoundException {
		logger.info("Get user details by id");
		User user= userService.findUserById(userid);
		return  ResponseEntity.ok(user);
	}

	@PostMapping("/user")
	@ApiOperation(value="Add new User")
	public User saveUser( @RequestBody User user1 ) throws ValidationException {
		logger.info("Add user details");
		return userService.saveUser(user1);
	}

	@PutMapping("/user/{id}")
	@ApiOperation(value="Update user data using user Id")
	public ResponseEntity<User> updateUserById(@PathVariable(value = "id") Integer userid,
			 @RequestBody User user) throws ResourceNotFoundException {
		logger.info("Update user details by id");
		User user1= userService.updateUser(userid, user);
		return  ResponseEntity.ok(user1);
	}
	 @DeleteMapping("/user/{id}")
	 @ApiOperation(value="Delete user data using user Id")
	 public Map<String, Boolean>  deletePolicy(@PathVariable(value = "id") Integer userId,@RequestBody User user) throws ResourceNotFoundException	{
		 logger.info("Delete user details by id");	
		 User user1 = userService.findUserById(userId);
			userService.deleteUser(user1);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
 }

}
