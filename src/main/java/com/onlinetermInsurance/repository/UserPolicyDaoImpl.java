package com.onlinetermInsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.UserPolicy;


@Repository
@EnableJpaRepositories
public interface UserPolicyDaoImpl extends JpaRepository<UserPolicy, Integer>{

	 @Query(value="select * from user_policy where user_id=?1 LIMIT 1",nativeQuery=true)
	 UserPolicy findByUserId(int userId);
	 @Query(value="select * from user_policy where user_policy_id=?1",nativeQuery=true)
	  UserPolicy findByUserPolicyId(int userpolicyid);
	 
}
