package com.onlinetermInsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.Login;


@Repository
public interface LoginDao extends JpaRepository<Login,Integer>  {

	@Query(value="select * from login where l_id=?1",nativeQuery=true)
	 Login findByLoginId(int lid);
	
	@Query(value="select * from login where username=?1 and password=?2",nativeQuery=true)
	 Login getLoginByUserName(String username,String password);
	
	public Login findByUserName(String username);
	
}
