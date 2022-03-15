package com.onlinetermInsurance.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.onlinetermInsurance.entity.Payments;
import com.onlinetermInsurance.repository.PaymentDaoImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

	@MockBean
	private PaymentDaoImpl paymentDaoImpl;
	
	@Autowired(required=true)
	PaymentService paymentService;
	
	@Test
	public void testGetAll()
	{
		Payments payment=getPayment();
		
		List<Payments> paymentList = new ArrayList<>();
		
		Payments payment1=new Payments();
		payment1.setAmount(1000);
		payment1.setDateOfPayment(Date.valueOf("2020-11-18"));
		payment1.setPolicyNo(102);
		payment1.setUserId(102);
		
		paymentList.add(payment1);
		paymentList.add(payment);
        Mockito.when(paymentDaoImpl.findAll()).thenReturn(paymentList);
        assertThat(paymentService.getall()).isEqualTo(paymentList);
	}
	@Test
	public void findByUserIdAndPolicyNoTest()
	{
		Payments payment1=new Payments();
		payment1.setAmount(1000);
		payment1.setDateOfPayment(Date.valueOf("2020-11-18"));
		payment1.setPolicyNo(102);
		payment1.setUserId(102);
		
		List<Payments> paymentList = new ArrayList<>();
		paymentList.add(payment1);
		Mockito.when(paymentDaoImpl.findByUserIdAndPolicyNo(payment1.getUserId(), payment1.getPolicyNo())).thenReturn(paymentList);
        assertThat(paymentService.findByUserIdAndPolicyNo(payment1.getUserId(), payment1.getPolicyNo())).isEqualTo(paymentList);
	}
	@Test
	public void findTotalAmountTest()
	{
		Payments payment1=new Payments();
		payment1.setAmount(1000);
		payment1.setDateOfPayment(Date.valueOf("2020-11-18"));
		payment1.setPolicyNo(102);
		payment1.setUserId(102);
		
		Mockito.when(paymentDaoImpl.findTotalAmountPaid(payment1.getUserId(), payment1.getPolicyNo())).thenReturn(1000.0);
        assertThat(paymentService.findTotalAmountPaid(payment1.getUserId(), payment1.getPolicyNo())).isEqualTo(1000.0);
	}
	
	@Test
    public void makePayementTest(){
		Payments payment=getPayment();

        Mockito.when(paymentDaoImpl.save(payment)).thenReturn(payment);
        assertThat(paymentService.MakePayment(payment)).isEqualTo(payment);
    }
	
    @SuppressWarnings("deprecation")
	@Test
    public void deletePaymentTest() throws Exception{
    	Payments payment=new Payments();
		payment.setAmount(1000);
		payment.setDateOfPayment(Date.valueOf("2020-11-18"));
		payment.setPolicyNo(102);
		payment.setUserId(156);

        Mockito.when(paymentDaoImpl.save(payment)).thenReturn(payment);
        Mockito.when(paymentDaoImpl.findByReceiptNo(181)).thenReturn(payment);
        paymentDaoImpl.delete(payment);
        Mockito.when(paymentDaoImpl.findByReceiptNo(181)).thenReturn(payment);
       // Assert.assertEquals(payment, new Payments());   
        Mockito.when(paymentDaoImpl.existsById(payment.getReceiptNo())).thenReturn(false);
        assertFalse(paymentDaoImpl.existsById(payment.getReceiptNo()));
        
        
    }
    @Test
	public void findByRecieptNoTest()
	{
		Payments payment1=new Payments();
		payment1.setAmount(1000);
		payment1.setDateOfPayment(Date.valueOf("2020-11-18"));
		payment1.setPolicyNo(102);
		payment1.setUserId(102);
		
		List<Payments> paymentList = new ArrayList<>();
		paymentList.add(payment1);
		Mockito.when(paymentDaoImpl.findByReceiptNo(182)).thenReturn(payment1);
        assertThat(paymentService.findByReceiptNo(182)).isEqualTo(payment1);
	}  
	private Payments getPayment() 
	 {
		 Payments payment=new Payments();
	     payment.setUserId(155);
	     payment.setAmount(1000);
	     payment.setPolicyNo(101);
	     payment.setDateOfPayment(Date.valueOf("2020-11-18")); 
	     return payment;
	 }
}
