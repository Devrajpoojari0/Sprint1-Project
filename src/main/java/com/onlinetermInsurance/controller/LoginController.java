package com.onlinetermInsurance.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinetermInsurance.entity.Login;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(description="Payment Controller class for all url based function")
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@GetMapping("/getAll")
	@ApiOperation(value="Get all Login details")
	public List<Login> getAll() {
		logger.info("Get all Login");
		return  loginServiceImpl.getAllUserCredentials();
	}

	@GetMapping("/login/{username}/{password}")
	@ApiOperation(value="Get Login by username and password")
	public ResponseEntity<Login> getLoginByUserName(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password) throws ResourceNotFoundException {
		logger.info("Login by username and password");
		Login login=loginServiceImpl.getLoginByUserName(username, password);
		return  ResponseEntity.ok(login);
	}

	@PutMapping("/updateLogin/{username}/{password}")
	@ApiOperation(value="Update Login details")
	public ResponseEntity<Login> UpdateLoginByUserName(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password,@RequestBody Login login) throws ResourceNotFoundException {
		logger.info("Update Login details");
		Login logintemp=loginServiceImpl.getLoginByUserName(username, password);
		loginServiceImpl.upateLoginIdPassword(logintemp);
		return  ResponseEntity.ok(logintemp);
	}
	@ApiOperation(value="Deleting the user.....")
	@DeleteMapping("/deleteusercd")
	public ResponseEntity<String> deleteUserCd(@RequestBody Login l) throws ValidationException, ResourceNotFoundException {
		String s = loginServiceImpl.deleteUserCredentials(l.getUserName(), l.getPassword());
		logger.info("Deleting the user.....");
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@ApiOperation(value="Adding User.....")
	@PostMapping("/addusercd")
	public ResponseEntity<Login> addCredentials(@RequestBody Login l) throws ValidationException, ResourceNotFoundException {
		Login adduser = loginServiceImpl.addUserCredentials(l);
		logger.info("Adding the user.....");
		return new ResponseEntity<Login> (adduser, HttpStatus.OK);
	}
}