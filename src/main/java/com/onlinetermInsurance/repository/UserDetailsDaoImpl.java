package com.onlinetermInsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.HealthModule;



@Repository
public interface UserDetailsDaoImpl extends JpaRepository<HealthModule, Integer> {
	@Query(value="select * from healthmodule where Medical_Id=?1",nativeQuery=true)
	  HealthModule findByMedicalId(Integer medicalId);
	
}
