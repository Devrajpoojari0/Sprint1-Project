package com.onlinetermInsurance.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.repository.UserDaoImpl;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
	 @MockBean
	 private UserDaoImpl userDaoImpl;
	
	 @Autowired
	 private UserService userService;
	 @Test
	 public void testGetUserById() throws Exception{
		 User user=new User();
		 user.setUserId(101);
		 user.setFname("shilpa");
		    user.setLname("Kumari");
		    user.setPhoneNo((long) 67123467);
	        user.setDob(Date.valueOf("2020-11-18"));
	        user.setAadhar("87543");
	        

	      Mockito.when(userDaoImpl.findByUserId(101)).thenReturn(user);
	    		  //findUserPolicyById()).get()).thenReturn(user);
	        		//Mockito.when(userpolicyDaoImpl.findById(user.getUserpolicyid()).get()).thenReturn(user);
		        assertThat(userService.findUserById(101)).isEqualTo(user);
		    }

		@Test
		void testDeleteUser() throws Exception {
			 User user=new User();
			 user.setUserId(100);
			 user.setFname("shilpa");
			    user.setLname("Kumari");
			    user.setPhoneNo((long) 67123467);
		        user.setDob(Date.valueOf("2020-11-18"));
		        user.setAadhar("87543");
		        
			userDaoImpl.deleteById(user.getUserId());
	        System.out.println(userDaoImpl.findById(100));
	        Assert.assertFalse(userDaoImpl.findById(100).equals(null));
		}
		@Test
		void testUpdateUserPolicyById() throws Exception {
			 User user=new User();
			 user.setUserId(101);
			 user.setFname("shilpa");
			    user.setLname("Kumari");
			    user.setPhoneNo((long) 67123467);
		        user.setDob(Date.valueOf("2020-11-18"));
		        user.setAadhar("87543");
			      Mockito.when(userDaoImpl.findByUserId(101)).thenReturn(user);
			        user.setLname("kumari");
			        Mockito.when(userDaoImpl.save(user)).thenReturn(user);
			        System.out.println(user.getLname());
			       // assertThat(userPolicyService.updateUserPolicy(101, user)).isEqualTo(user);
		}
		@Test
		void testGetAllUsers() {
			 User user=new User();
			 user.setUserId(100);
			 user.setFname("shilpa");
			    user.setLname("Kumari");
			    user.setPhoneNo((long) 67123467);
		        user.setDob(Date.valueOf("2020-11-18"));
		        user.setAadhar("87543");
		       

               User user1=new User();
		        user1.setUserId(100);
				 user1.setFname("shilpa");
				    user1.setLname("Kumari");
				    user1.setPhoneNo((long) 67123467);
			        user1.setDob(Date.valueOf("2020-11-18"));
			        user1.setAadhar("87543");
		       

	        List<User> userList = new ArrayList<>();
	        userList.add(user);
	        userList.add(user1);

	        Mockito.when(userDaoImpl.findAll()).thenReturn(userList);
	        assertThat(userService.getAllUsers()).isEqualTo(userList);
		}	@Test
		void testSaveUser() {
			User user=new User();
			user.setUserId(100);
			 user.setFname("shilpa");
			    user.setLname("Kumari");
			    user.setPhoneNo((long) 67123467);
		        user.setDob(Date.valueOf("2020-11-18"));
		        user.setAadhar("87543");
			
		}
		


	

}
