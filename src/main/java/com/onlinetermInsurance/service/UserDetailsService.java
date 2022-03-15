package com.onlinetermInsurance.service;
import java.util.List;

import com.onlinetermInsurance.entity.HealthModule;
import com.onlinetermInsurance.exception.ResourceNotFoundException;




public interface UserDetailsService {
	public List<HealthModule> getAllUserDetails();
	 public HealthModule saveUserDetails(HealthModule health);
	 public HealthModule updateUserDetailsById(Integer medicalId,HealthModule healths) throws ResourceNotFoundException;
	 public boolean deleteUserDetails(Integer medicalId) throws ResourceNotFoundException;
	 public HealthModule getUserDetailsById(Integer medicalId) throws ResourceNotFoundException;

}
