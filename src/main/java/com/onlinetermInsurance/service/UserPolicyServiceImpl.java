package com.onlinetermInsurance.service;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinetermInsurance.entity.UserPolicy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.UserPolicyDaoImpl;


@Service
@Transactional
public class UserPolicyServiceImpl implements UserPolicyService{
	
	public static final Logger logger = LoggerFactory.getLogger(UserPolicyServiceImpl.class);

	@Autowired
	private UserPolicyDaoImpl userpolicy;
	

	public List<UserPolicy> getAllUserPolicies(){
		logger.info("User Policy Service get all");
		return userpolicy.findAll();
	}

	public UserPolicy findUserPolicyById(@PathVariable(value="id")Integer userpolicyid) throws ResourceNotFoundException {
		logger.info("User Policy Service get by Id");
		UserPolicy user =userpolicy.findByUserPolicyId(userpolicyid);
		if(user==null)
		{
			new ResourceNotFoundException("User Policy not found for this id :: " + userpolicyid);
		}
		return user;
	}


    public boolean deleteUserPolicy(UserPolicy userPolicy) throws ResourceNotFoundException {
    	logger.info("User Policy Service delete by Id");
    	UserPolicy user = userpolicy.findById(userPolicy.getUserpolicyid())
				.orElseThrow(() -> new ResourceNotFoundException("User Policy ot found for this id :: " + userPolicy.getPolicyid()));
    	

    	 userpolicy.delete(user);
    	 if(user==null){
	            return true;
	        }
	        return false;
    }
		
    
    public UserPolicy findByUserId(int userId)
    {
    	logger.info("User Policy Service get by user Id and Policy No");
    	return userpolicy.findByUserId(userId);
    }

	public UserPolicy saveUserPolicy(UserPolicy user) {
		logger.info("User Policy Service Add");
		
		return userpolicy.save(user);
	}

	public UserPolicy updateUserPolicy(int userId,int policyNo,UserPolicy user) throws ResourceNotFoundException {
		logger.info("User Policy Service update");
		UserPolicy user1 = userpolicy.findByUserId(userId);
		if(user1==null)
			{
			new ResourceNotFoundException("User Policy not found for this id :: " +userId);
			}
		user1.setUserid(user.getUserid());
		user1.setPolicyid(user.getPolicyid());
		user1.setRegisteredDate(user.getRegisteredDate());
		user1.setAmount(user.getAmount());
		user1.setTotalTime(user.getTotalTime());
		user1.setMonthOver(user.getMonthOver());
		user1.setAmountPaid(user.getAmountPaid());
		final UserPolicy updateduserPolicy =userpolicy.save(user1);
		return updateduserPolicy;
	}
	

	public List<UserPolicy> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}


