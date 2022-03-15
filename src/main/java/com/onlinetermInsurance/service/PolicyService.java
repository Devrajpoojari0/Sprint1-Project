package com.onlinetermInsurance.service;

import java.util.List;

import com.onlinetermInsurance.entity.Policy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;


public interface PolicyService {
	public List<Policy> getAllPolicies();
	public Policy findPolicyById(Integer policyid) throws ResourceNotFoundException;
	public boolean deletePolicyById(Integer policyid)throws ResourceNotFoundException;
	public Policy savePolicy(Policy policy);
	public Policy updatePolicy(Integer policyid,Policy policy)throws ResourceNotFoundException;

}
