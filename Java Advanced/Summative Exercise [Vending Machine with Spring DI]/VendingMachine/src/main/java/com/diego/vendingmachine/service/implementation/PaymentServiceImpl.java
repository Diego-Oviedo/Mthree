package com.diego.vendingmachine.service.implementation;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.PaymentDAO;
import com.diego.vendingmachine.service.InsufficientFundsException;
import com.diego.vendingmachine.service.PaymentService;

@Component("payment_service")
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	@Qualifier("payment_dao")
	private PaymentDAO dao;

	public Map<String, BigDecimal> receivePayment(BigDecimal payment, BigDecimal unit_price) throws 
																									InsufficientFundsException, 
																									DataSourceException{
		
		int result = payment.compareTo(unit_price);
		Map<String, BigDecimal> change = null;
		
		if (result == -1 ) {//If payment is less than the unit price 
			//throw new InsufficientFundsException("Insufficient Funds...");
			
			change = change;
		}else {
			
			change = dao.getChange(payment, unit_price);
			
		}
		
		return change;
	}

	public BigDecimal refundCustomer(BigDecimal amount_refunded) {
		return amount_refunded;
	}

}
