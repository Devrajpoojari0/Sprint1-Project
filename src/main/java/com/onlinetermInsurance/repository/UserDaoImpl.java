package com.onlinetermInsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.User;



@Repository
public interface UserDaoImpl extends JpaRepository<User,Integer> {
	@Query(value="select * from user_details where user_id=?1",nativeQuery=true)
	  User findByUserId(int userid);
	  public User findByFname(String j);
}
