package com.onlinetermInsurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.onlinetermInsurance.entity.UserPolicy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.UserPolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@Api(description="User Policy Controller class for all url based function")
public class UserPolicyController {
	public static final Logger logger = LoggerFactory.getLogger(UserPolicyController.class);
	
	@Autowired
	private UserPolicyService userPolicyService;

	@GetMapping("/userpolicy")
	@ApiOperation(value="Get all user policy details")
	public List<UserPolicy> getAllUserPolicies() {
		logger.info("Get all User Policy");
		return userPolicyService.getAllUserPolicies();
	}

	@GetMapping("/userpolicy/{userId}")
	@ApiOperation(value="Get all user policy details for particular user and policy")
	public ResponseEntity<UserPolicy> getByUserIdAndPolicyId(@PathVariable(value = "userId")int userId) throws ResourceNotFoundException {
		logger.info("Get User Policy by user Id");
		UserPolicy user= userPolicyService.findByUserId(userId);
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/userpolicy")
	@ApiOperation(value="User buy policy")
	public UserPolicy createUserPolicy( @RequestBody UserPolicy userPolicy ) {
		logger.info("Add User Policy");
		return userPolicyService.saveUserPolicy(userPolicy);
	}

	@PutMapping("/userpolicy/{userId}/{policyNo}")
	@ApiOperation(value="Update User policy details")
	public ResponseEntity<UserPolicy> updateUserPolicyById(@PathVariable(value = "userId")int userId,@PathVariable("policyNo") int policyNo,
			 @RequestBody UserPolicy userPolicy) throws ResourceNotFoundException {
		logger.info("Update User Policy by user Id and Policy No");
		UserPolicy userPolicyTemp=userPolicyService.findByUserId(userId);
		UserPolicy user1= userPolicyService.updateUserPolicy(userPolicyTemp.getUserid(),userPolicyTemp.getPolicyid(), userPolicy);
		return  ResponseEntity.ok(user1);
	}
	
	 @DeleteMapping("/userpolicy/{id}")
	 @ApiOperation(value="Delete policy user bought")
	 public Map<String, Boolean> deleteUserPolicy(@PathVariable(value = "id") Integer userpolicyid) throws ResourceNotFoundException	{
		 	logger.info("Delete User Policy by user Id and Policy No");
		 	UserPolicy user = userPolicyService.findUserPolicyById(userpolicyid);
			userPolicyService.deleteUserPolicy(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
    }
}