package com.onlinetermInsurance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetermInsurance.entity.Payments;
import com.onlinetermInsurance.repository.PaymentDaoImpl;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	
	public static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	PaymentDaoImpl paymentDaoImpl;
	@Autowired
	PolicyService policyService;
	
	@Override
	public List<Payments> getall()
	{
		logger.info("Payment Service get all");
		return paymentDaoImpl.findAll();
		 
	}
	@Override
	public List<Payments> findByUserIdAndPolicyNo(int userId,int policyNo)
	{
		logger.info("Payment Service find by UserIdAndPolicyNo");
		return paymentDaoImpl.findByUserIdAndPolicyNo(userId,policyNo);
	}
	@Override
	public Double findTotalAmountPaid(int userId,int policyNo)
	{
		logger.info("Payment Service total amount paid");
		return paymentDaoImpl.findTotalAmountPaid(userId,policyNo);
	}
	@Override
	public Payments MakePayment(Payments pp)
	{
		logger.info("Payment Service make Payment");
		return paymentDaoImpl.save(pp);
	}
	@Override
	public boolean deletePayment(Payments payment)
	{
		logger.info("Payment Service delete payment");
		paymentDaoImpl.delete(payment);
		return true;
	}
	@Override
	public Payments findByReceiptNo(int receiptNo)
	{
		logger.info("Payment Service findbyreciept no");
		return paymentDaoImpl.findByReceiptNo(receiptNo);
	}



}
