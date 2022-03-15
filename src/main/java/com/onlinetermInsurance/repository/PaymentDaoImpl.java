package com.onlinetermInsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.onlinetermInsurance.entity.Payments;
import com.onlinetermInsurance.entity.UserPolicy;

@EnableJpaRepositories
@Repository
public interface PaymentDaoImpl extends JpaRepository<Payments, Integer>{

	
	UserPolicy policy=new UserPolicy();
	
	 @Query(value="select * from payment where user_id=?1 and policy_id=?2",nativeQuery=true)
	 List<Payments> findByUserIdAndPolicyNo(int userId,int policyNo);

	 @Query(value="select * from payment where recript_no=?1",nativeQuery=true)
	 Payments findByReceiptNo(int receiptNo);

	 @Query(value="select sum(amount) from payment where user_id=?1 and policy_id=?2",nativeQuery=true)
	 Double findTotalAmountPaid(int userId,int policyNo);
}