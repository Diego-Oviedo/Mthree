package com.diego.vendingmachine.service.implementation;

import java.math.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.service.*;

@Component("payment_service")
public class PaymentServiceImpl implements PaymentService {
	
	public enum Denominations {
		DOLLAR, QUARTER, DIME, NICKEL,PENNY
	}
	
	public BigDecimal getDenomination(Denominations denomination) throws DataSourceException {
		
		switch(denomination) {
			case DOLLAR:
				return new BigDecimal("1").setScale(0, RoundingMode.UNNECESSARY);
			case QUARTER: 
				return new BigDecimal("0.25").setScale(2, RoundingMode.HALF_UP);
			case DIME:
				return new BigDecimal("0.10").setScale(2, RoundingMode.HALF_UP);
			case NICKEL:
				return new BigDecimal("0.05").setScale(2, RoundingMode.HALF_UP);
			case PENNY:
				return new BigDecimal("0.01").setScale(2, RoundingMode.HALF_UP);
			default:	
				throw new DataSourceException("Error selecting denominations...");
		}

	} 

	public Map<String, BigDecimal> receivePayment(BigDecimal payment, BigDecimal unit_price)
			throws InsufficientFundsException {

		Map<String, BigDecimal> change = null;
		int result = payment.compareTo(unit_price);
		
		if (result == -1) {// If payment is less than the unit price 
			throw new InsufficientFundsException("Insufficient Funds...");
		} else {
		
		try {
			
			BigDecimal DOLLAR = getDenomination(Denominations.DOLLAR);
			BigDecimal QUARTER = getDenomination(Denominations.QUARTER);
			BigDecimal DIME = getDenomination(Denominations.DIME);
			BigDecimal NICKEL = getDenomination(Denominations.NICKEL);
			BigDecimal PENNY = getDenomination(Denominations.PENNY);

			BigDecimal reminder = payment.setScale(2, RoundingMode.UNNECESSARY)
					.subtract(unit_price.setScale(2, RoundingMode.UNNECESSARY));

			BigDecimal dollars = reminder.divide(DOLLAR).setScale(0, RoundingMode.DOWN);
			reminder = reminder.remainder(DOLLAR);
			dollars.setScale(0, RoundingMode.HALF_EVEN);

			BigDecimal quarters = reminder.divide(QUARTER).setScale(0, RoundingMode.DOWN);
			reminder = reminder.remainder(QUARTER);
			quarters.setScale(0, RoundingMode.HALF_EVEN);

			BigDecimal dimes = reminder.divide(DIME).setScale(0, RoundingMode.DOWN);
			reminder = reminder.remainder(DIME);
			dimes.setScale(0, RoundingMode.HALF_EVEN);

			BigDecimal nickels = reminder.divide(NICKEL).setScale(0, RoundingMode.DOWN);
			reminder = reminder.remainder(NICKEL);
			nickels.setScale(0, RoundingMode.HALF_EVEN);

			BigDecimal pennies = reminder.divide(PENNY).setScale(0, RoundingMode.CEILING);
			reminder = reminder.remainder(PENNY);
			pennies.setScale(0, RoundingMode.CEILING);

			change = new HashMap<String, BigDecimal>();

			change.put("DOLLARS", dollars);
			change.put("QUARTERS", quarters);
			change.put("DIMES", dimes);
			change.put("NICKELS", nickels);
			change.put("PENNIES", pennies);
			
			
			
		}catch(Exception e) {
			
		}
		}
		
		return change;
	}

	public BigDecimal refundCustomer(BigDecimal amount_refunded) {
		return amount_refunded;
	}

}
