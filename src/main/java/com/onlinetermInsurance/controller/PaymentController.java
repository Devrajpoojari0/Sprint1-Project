package com.onlinetermInsurance.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetermInsurance.entity.Payments;
import com.onlinetermInsurance.entity.UserPolicy;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.UserPolicyDaoImpl;
import com.onlinetermInsurance.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/payment")
@Api(description="Payment Controller class for all url based function")
public class PaymentController {
	
	public static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private UserPolicyDaoImpl userPolicyDaoImpl;
	
	@Autowired
	private PaymentService paymentService;

	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");  
	 LocalDateTime now = LocalDateTime.now(); 

	@GetMapping("/getall")
	@ApiOperation(value="Get list of all payments")
	public List<Payments> getAll() {
		logger.info("Get all payment");
		return paymentService.getall();
	}
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/getbyreciept/{receiptNo}")
	@ApiOperation(value="Get payment details by receipt number")
	public Payments getReciept(@PathVariable(value = "receiptNo")int receiptNo) throws ResourceNotFoundException {
		logger.info("Get by reciept");
		Payments payment =  paymentService.findByReceiptNo(receiptNo);
		if(payment==null)
		{
			new ResourceNotFoundException("Payment details not found the id :: " + receiptNo);
		}
		return payment;
	}

	@GetMapping("/pay/{userId}/{policyNo}")
	@ApiOperation(value="Get payment details paid by user for a policy")
	public double getTotalAmountPaid(@PathVariable(value = "userId")int userId,@PathVariable("policyNo") int policyNo)
			throws ResourceNotFoundException {
		logger.info("Get total amount paid by user");
		double payment =  paymentService.findTotalAmountPaid(userId,policyNo);
		if(payment==0)
		{
			new ResourceNotFoundException("Payment details not found the id :: " + userId);
		
		}
		return payment;
	}
	@GetMapping("/payment/{userId}/{policyNo}")
	@ApiOperation(value="Get payment details paid by user for all policies user bought")
	public List<Payments> getPaymentByUserId(@PathVariable(value = "userId")int userId,@PathVariable("policyNo") int policyNo)
			throws ResourceNotFoundException {
		logger.info("Get all payment made by user");
		List<Payments> payment = paymentService.findByUserIdAndPolicyNo(userId,policyNo);
		if(payment==null)
		{
			new ResourceNotFoundException("Payment details not found the id :: " + userId);
		
		}
		return payment;
	}
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/pay")
	@ApiOperation(value="Make payment for policy by user")
	public Payments MakePayment( @RequestBody Payments payment ) {
		logger.info("Make payment");
		UserPolicy policy = userPolicyDaoImpl.findByUserId(payment.getUserId());
		if(policy==null)
		{
			new ResourceNotFoundException("User or policy not found");
		
		}
		policy.setAmountPaid(policy.getAmountPaid()+payment.getAmount());
		policy.setMonthOver(policy.getMonthOver()+1);
		userPolicyDaoImpl.save(policy);
		Payments payments=payment;
		return paymentService.MakePayment(payments);	
	}


	@DeleteMapping("/payment/{receiptNo}")
	@ApiOperation(value="Delete payment detail")
	public Map<String, Boolean> deletePayment(@PathVariable(value = "receiptNo")int receiptNo)
			throws ResourceNotFoundException {
		logger.info("Delete payment");
		Payments payment =  paymentService.findByReceiptNo(receiptNo);
		if(payment==null)
		{
			new ResourceNotFoundException("Payment details not found the reciept :: " + receiptNo);
		
		}
		paymentService.deletePayment(payment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
