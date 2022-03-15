package com.onlinetermInsurance.service;

import java.util.List;

import com.onlinetermInsurance.entity.UserPolicy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;


public interface UserPolicyService {

	public List<UserPolicy> getAllUserPolicies();
	public UserPolicy findUserPolicyById(Integer userpolicyid) throws ResourceNotFoundException;
	public boolean deleteUserPolicy(UserPolicy userPolicy)throws ResourceNotFoundException;
	public UserPolicy saveUserPolicy(UserPolicy user);
	public UserPolicy updateUserPolicy(int userId,int policyNo,UserPolicy user)throws ResourceNotFoundException;
	public UserPolicy findByUserId(int userId);
	//public List<UserPolicy> findByUserIdAndPolicyId(int userId,int policyNo);
}
