package com.onlinetermInsurance.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetermInsurance.entity.Login;
import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.LoginDao;
import com.onlinetermInsurance.repository.UserDaoImpl;
import com.onlinetermInsurance.service.LoginService1;

@Service
public class LoginServiceImpl implements LoginService1 {
	public static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public List<Login> getAllUserCredentials()
	{
		logger.info("Login Service get all");
		return loginDao.findAll();
		 
	}
	public Login getLoginByUserName(String username,String password)
	{
		return loginDao.getLoginByUserName(username, password);
	}
	public void upateLoginIdPassword(Login login)
	{
		int id=login.getlId();
		Login loginTemp=loginDao.findByLoginId(id);
		loginDao.save(loginTemp);
	}
	public Login addUserCredentials(Login l) throws ValidationException, ResourceNotFoundException {
		User user = new User();

		String k = l.getUserType();
		String j = l.getUserName();
		String u = l.getPassword();

		String regularExpression = "^[A-Za-z][A-Za-z0-9]{3,20}$";
		String regularExpressionpass = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		if (!j.matches(regularExpression)) {
			throw new ValidationException("invalid username try again.."
					+ "Rules --> first letter must be an alphabet and minmum 3 characters");
		} else if (!u.matches(regularExpressionpass)) {
			throw new ValidationException("invalid password try again.."
					+ "Minimum eight characters, at least one letter, one number and one special character");
		}
		else if (k =="" || k == null) {
			throw new ValidationException("User type must not be empty");
		}

		try {
			String name = userDaoImpl.findByFname(j).getFname();
			user = userDaoImpl.findByFname(name);
			l.setUser(user);
			loginDao.save(l);
		} catch (NullPointerException ex) {
			throw new ResourceNotFoundException("username not found enter valid username....");
		}
		return l;
	}
	@Override
	public String deleteUserCredentials(String username, String password) throws ValidationException, ResourceNotFoundException {
		try {
			String s = loginDao.findByUserName(username).getUserName();
			Login l = loginDao.findByUserName(s);

			if (!password.equals(l.getPassword())) {
				throw new ValidationException("password mismatch try again...");
			} else {
				loginDao.delete(l);
				//userDaoImpl.delete(l.getUser());
			}

		} catch (NullPointerException e) {
			throw new ResourceNotFoundException("username not found enter valid username....");
		}
		return "deleted user: " + username;
	}
	@Override
	public String updateUserCredentials(String username, String password) throws ResourceNotFoundException {
		try {
			String s = loginDao.findByUserName(username).getUserName();
			Login l = loginDao.findByUserName(s);
			l.setPassword(password);
			loginDao.save(l);
		} catch (NullPointerException ex) {
			throw new ResourceNotFoundException("username not found enter valid username....");
		}
		return "password changed sucessfully";
	}
}
