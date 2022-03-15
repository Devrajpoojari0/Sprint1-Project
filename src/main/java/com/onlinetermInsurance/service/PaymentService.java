package com.onlinetermInsurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinetermInsurance.entity.Payments;

@Service
public interface PaymentService {
	public abstract List<Payments> getall();
	public abstract List<Payments> findByUserIdAndPolicyNo(int userId,int policyNo);
	public abstract Double findTotalAmountPaid(int userId,int policyNo);
	public abstract Payments MakePayment(Payments pp);
	public abstract boolean deletePayment(Payments payment);
	public abstract Payments findByReceiptNo(int receiptNo);
}
