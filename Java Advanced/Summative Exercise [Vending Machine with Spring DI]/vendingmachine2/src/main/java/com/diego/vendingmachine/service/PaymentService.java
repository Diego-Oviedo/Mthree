package com.diego.vendingmachine.service;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Component;


@Component("payment_service")
public interface PaymentService {


	public Map<String, BigDecimal> receivePayment(BigDecimal payment, BigDecimal unit_price) throws InsufficientFundsException;
	
	public BigDecimal refundCustomer(BigDecimal amount_refunded);

}
