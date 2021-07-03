package com.diego.vendingmachine.service;

import java.math.BigDecimal;
import java.util.Map;

import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

public interface PaymentService {
	
	public Map<String,BigDecimal> receivePayment(BigDecimal payment, BigDecimal unit_price) throws InsufficientFundsException;
	
	public BigDecimal refundCustomer(BigDecimal amount_refunded);
}
