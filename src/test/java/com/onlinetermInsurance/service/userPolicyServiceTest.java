package com.onlinetermInsurance.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinetermInsurance.entity.Policy;
import com.onlinetermInsurance.repository.PolicyDaoImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
 public class userPolicyServiceTest {
	 @MockBean
	 private PolicyDaoImpl policyDaoImpl;
	
	 @Autowired
	 private PolicyService policyService;
	
	 @Test
	 public void testGetPolicyById() throws Exception{
		 Policy policy=new Policy();
		    policy.setId(122);
		    policy.setDescription("one crore");
		    policy.setYearsOfPayment(2);
	        policy.setAmount(12000.00);
	        policy.setMaturityperiod(21);
	        policy.setMaturityamount(21000.00);
	        Mockito.when(policyDaoImpl.findByPolicyId(policy.getId())).thenReturn(policy);
	        assertThat(policyService.findPolicyById(122)).isEqualTo(policy);
		    }


	@Test
	void testDeletePolicy() throws Exception {
		Policy policy=new Policy();
		policy.setId(125);
	    policy.setDescription("Three crore");
	    policy.setYearsOfPayment(4);
        policy.setAmount(13400.00);
        policy.setMaturityperiod(25);
        policy.setMaturityamount(25000.00);
		policyDaoImpl.deleteById(policy.getId());
        System.out.println(policyDaoImpl.findById(125));
        Assert.assertFalse(policyDaoImpl.findById(125).equals(null));
	}

	@Test
	void testUpdatePolicyById() throws Exception {
		Policy policy1=new Policy();
		policy1.setId(127);
	    policy1.setDescription("Three crore");
	    policy1.setYearsOfPayment(4);
	    policy1.setAmount(13400.00);
	    policy1.setMaturityperiod(25);
	    policy1.setMaturityamount(25000.00);
			
		        Mockito.when(policyDaoImpl.findByPolicyId(policy1.getId())).thenReturn(policy1);
		        policy1.setAmount(13400.00);
		        Mockito.when(policyDaoImpl.save(policy1)).thenReturn(policy1);
		        System.out.println(policy1.getAmount());
		        //assertThat(policyService.updatePolicy(127, policy1)).isEqualTo(policy1);
	}

	@Test
	void testGetAllPolicies() {
		Policy policy1=new Policy();
		policy1.setId(125);
	    policy1.setDescription("Three crore");
	    policy1.setYearsOfPayment(4);
        policy1.setAmount(13400.00);
        policy1.setMaturityperiod(25);
        policy1.setMaturityamount(25000.00);


        Policy policy2=new Policy();
      		policy2.setId(126);
      	    policy2.setDescription("five crore");
      	    policy2.setYearsOfPayment(4);
              policy2.setAmount(15400.00);
              policy2.setMaturityperiod(25);
              policy2.setMaturityamount(25000.00);

        List<Policy> userPolicyList = new ArrayList<>();
        userPolicyList.add(policy1);
        userPolicyList.add(policy2);

        Mockito.when(policyDaoImpl.findAll()).thenReturn(userPolicyList);
        assertThat(policyService.getAllPolicies()).isEqualTo(userPolicyList);
	}

	@Test
	void testSaveProduct() {
		Policy policy1=new Policy();
		policy1.setId(127);
	    policy1.setDescription("Three crore");
	    policy1.setYearsOfPayment(4);
	    policy1.setAmount(13400.00);
	    policy1.setMaturityperiod(25);
	    policy1.setMaturityamount(25000.00);
	    Mockito.when(policyDaoImpl.save(policy1)).thenReturn(policy1);
	    assertThat(policyService.savePolicy(policy1)).isEqualTo(policy1);
	}
}
