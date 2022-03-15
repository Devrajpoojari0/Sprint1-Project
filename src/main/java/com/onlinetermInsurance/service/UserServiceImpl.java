package com.onlinetermInsurance.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.entity.UserPolicy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.UserDaoImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDaoImpl userDaoImpl;
	

	//getting all user datas 
	public List<User> getAllUsers(){
		logger.info("User Service get all");
		return userDaoImpl.findAll();
	}

	//finding users by id
	public User findUserById(@PathVariable(value="id")Integer userid) throws ResourceNotFoundException {
		logger.info("User Service get by id");
		User user1=userDaoImpl.findByUserId(userid);
		if(user1==null)
		{
			new ResourceNotFoundException("User Policy not found for this id :: " + userid);
		}
		return user1;
	}

	 public boolean deleteUser(User user) throws ResourceNotFoundException {
		 logger.info("User Service Delete");
	    	User user1 = userDaoImpl.findById(user.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User Policy ot found for this id :: " + user.getUserId()));
	    	

	    	 userDaoImpl.delete(user1);
	    	 if(user1==null){
		            return true;
		        }
		        return false;
	    	
	    }

	public User saveUser(User user1) throws ValidationException {
		logger.info("User Service Add user");
		String regex= "^[A-Za-z]{4,10}";
		String j=user1.getFname();
		String k=user1.getLname();
		if (!j.matches(regex)) 
		{
			throw new ValidationException("invalid first name try again.."
			+ "Rules --> first letter must be an alphabet and min 4 , max 10characters");
		}
		else if(!k.matches(regex))
		{
			throw new ValidationException("invalid last name try again.."
					+ "Rules --> first letter must be an alphabet and min 4 mx 10 characters");
		}
		else
		{
		return userDaoImpl.save(user1);
		}
		
		
	}

	public User updateUser(Integer userid,User users) throws ResourceNotFoundException {
		logger.info("User Service Update");
		User user1 = userDaoImpl.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userid));
		user1.setFname(users.getFname());
		user1.setLname(users.getLname());
		user1.setPhoneNo(users.getPhoneNo());
		user1.setAd(users.getAd());
		user1.setDob(users.getDob());
		user1.setAadhar(users.getAadhar());
		final User updateduser =userDaoImpl.save(user1);
		return updateduser;
	}
	




}


