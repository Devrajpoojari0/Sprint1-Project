package com.onlinetermInsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.Policy;



@Repository
public interface PolicyDaoImpl extends JpaRepository<Policy,Integer> {
	
	@Query(value="select * from policy where recript_no=?1",nativeQuery=true)
	 Policy findByPolicyId(int id);
	
}
