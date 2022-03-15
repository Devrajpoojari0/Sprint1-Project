package com.onlinetermInsurance.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetermInsurance.entity.HealthModule;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.UserDetailsDaoImpl;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDaoImpl userdetails;
	

	public HealthModule getUserDetailsById(Integer medicalId)
			throws ResourceNotFoundException {
		HealthModule  health =userdetails.findByMedicalId(medicalId);
		if(health==null)
		{
			 new ResourceNotFoundException("User not found for this id :: " + medicalId);
		}
		return health;
	}

	public boolean deleteUserDetails(Integer medicalId)
			throws ResourceNotFoundException {
	 HealthModule health = userdetails.findById(medicalId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + medicalId));

	 userdetails.delete(health);
	 if(null == health){
            return false;
        }
        return true;
}
 
	public HealthModule updateUserDetailsById(Integer medicalId,HealthModule healths) throws ResourceNotFoundException {
		 HealthModule health = userdetails.findById(medicalId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + medicalId));
		 health.setAadharNo(healths.getAadharNo());
			health.setName(healths.getName());
			health.setAddress(healths.getAddress());
			health.setPhoneNo(healths.getPhoneNo());
			health.setAge(healths.getAge());
			health.setAccident(healths.getAccident());
			health.setAlcohol(healths.getAlcohol());
		 
		final HealthModule updatedUser = userdetails.save(health);
		return updatedUser; 
		
	}
	public HealthModule saveUserDetails(HealthModule health) {
		
		return userdetails.save(health);
	}
	 public List<HealthModule> getAllUserDetails() {
			return userdetails.findAll();
			}
		 



	
	

	
}


