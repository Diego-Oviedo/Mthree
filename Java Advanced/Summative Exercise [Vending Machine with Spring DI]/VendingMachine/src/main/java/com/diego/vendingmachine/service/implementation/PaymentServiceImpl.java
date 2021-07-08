package com.diego.vendingmachine.service.implementation;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.InventoryException;
import com.diego.vendingmachine.model.dao.PaymentDAO;
import com.diego.vendingmachine.model.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.service.InsufficientFundsException;
import com.diego.vendingmachine.service.PaymentService;

@Component("payment_service")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	@Qualifier("payment_dao") 
	private PaymentDAO dao;

	public Map<String, BigDecimal> receivePayment(BigDecimal payment, BigDecimal unit_price)
			throws InsufficientFundsException, DataSourceException {

		int result = payment.compareTo(unit_price);
		Map<String, BigDecimal> change = null;

		try {

			if (result == -1) {// If payment is less than the unit price 
				// throw new InsufficientFundsException("Insufficient Funds...");

				change = change;
			} else {

				change = dao.getChange(payment, unit_price);

			}
		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InsufficientFundsException.class)) {
				throw new InsufficientFundsException(e.getMessage(), e.getCause()); 
			} else {
				e.printStackTrace();

			}
		}

		return change;
	}

	public BigDecimal refundCustomer(BigDecimal amount_refunded) {
		return amount_refunded;
	}

}
