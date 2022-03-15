package com.onlinetermInsurance.controller;

import java.util.List;

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
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.PolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@Api(description="Policy Controller class for all url based function")
public class PolicyController {
	public static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	
	
	@Autowired
	private PolicyService policyService;

	@GetMapping("/policy")
	@ApiOperation(value="Get all policy details")
	public List<Policy> getAllPolicy() {
		logger.info("Get all Policy");
		return  policyService.getAllPolicies();
	}

	@GetMapping("/policy/{id}")
	@ApiOperation(value="Get policy by policy id")
	public ResponseEntity<Policy> getUserPolicyById(@PathVariable(value = "id") Integer policyid) throws ResourceNotFoundException {
		logger.info("Get policy by id");
		Policy policy= policyService.findPolicyById(policyid);
		return  ResponseEntity.ok(policy);
	}
	@PostMapping("/policy")
	@ApiOperation(value="Create new policy ADD")
	public Policy saveUser( @RequestBody Policy policy1 ) {
		logger.info("Create Policy");
		return  policyService.savePolicy(policy1);
	}

	@PutMapping("/policy/{id}")
	@ApiOperation(value="Update policy")
	public ResponseEntity<Policy> updatePolicyById(@PathVariable(value = "id") Integer policyid,
			 @RequestBody Policy policy) throws ResourceNotFoundException {
		logger.info("Update policy by id");
		Policy policy1= policyService.updatePolicy(policyid, policy);
		return  ResponseEntity.ok(policy1);
	}
	 @DeleteMapping("/policy/{id}")
	 @ApiOperation(value="Delete policy by using policy id")
	 public ResponseEntity<Boolean> deleteUserPolicy(@PathVariable(value = "id") Integer policyid,@RequestBody Policy policy) throws ResourceNotFoundException	{
		 logger.info("Delete policy by id");
		 Boolean policy1 = policyService.deletePolicyById(policyid);
			return  ResponseEntity.ok(policy1);
    }

}
