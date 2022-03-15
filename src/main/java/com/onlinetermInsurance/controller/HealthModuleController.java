package com.onlinetermInsurance.controller;

import java.util.List;


//import javax.validation.Valid;

//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
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

import com.onlinetermInsurance.entity.HealthModule;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.UserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="HealthModuleController",description="REST Apis related to HealthModule Entity!!!")

@RestController
@RequestMapping("/api/v2")
public class HealthModuleController {
	
	@Autowired
	private UserDetailsService userService;
	@ApiOperation(value ="Retrieve all user details from the System",response=HealthModule.class,tags="HealthModuleController")
	@GetMapping("/userdetails")
	public List<HealthModule> getAllUserDetails() {
		
		return userService.getAllUserDetails();
	}
	@ApiOperation(value ="Adding a new User in the System",response=HealthModule.class,tags="HealthModuleController")
	@PostMapping("/userdetails")
	public HealthModule createUser( @RequestBody HealthModule health) {
		return userService.saveUserDetails(health);
	} 
	@ApiOperation(value ="Retrieve user details by id",response=HealthModule.class,tags="HealthModuleController")
	@GetMapping("/userdetails/{id}")
	public ResponseEntity<HealthModule> getUserById(@PathVariable(value = "id") Integer medicalId) throws ResourceNotFoundException {
		HealthModule health = userService.getUserDetailsById(medicalId);
		return  ResponseEntity.ok(health);

	}
	@ApiOperation(value ="Updating user details by id",response=HealthModule.class,tags="HealthModuleController")
	@PutMapping("/userdetails/{id}")
	public ResponseEntity<HealthModule> updateUserDetails(@PathVariable(value = "id") Integer medicalId,
			 @RequestBody HealthModule healths) throws ResourceNotFoundException {
		HealthModule health = userService.updateUserDetailsById(medicalId, healths);
		return  ResponseEntity.ok(health);
	}
	
	@ApiOperation(value ="Deleting user details by id",response=HealthModule.class,tags="HealthModuleController")
	@DeleteMapping("/userdetails/{id}")	
	public ResponseEntity<Boolean> deleteUserDetails(@PathVariable(value = "id") Integer medicalId,@RequestBody HealthModule health) throws ResourceNotFoundException	{
		Boolean health1 = userService.deleteUserDetails(medicalId);
		return  ResponseEntity.ok(health1);
	}
	
 
}
