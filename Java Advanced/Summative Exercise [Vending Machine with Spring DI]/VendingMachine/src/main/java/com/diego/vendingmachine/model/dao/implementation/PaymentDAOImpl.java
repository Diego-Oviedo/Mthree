package com.diego.vendingmachine.model.dao.implementation;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

@Component("payment_dao")
public class PaymentDAOImpl implements PaymentDAO {

	public Map<String,BigDecimal> getChange(BigDecimal payment, BigDecimal unit_price) {
		
		BigDecimal DOLLAR = new BigDecimal("1").setScale(0, RoundingMode.UNNECESSARY);
		BigDecimal QUARTER = new BigDecimal("0.25").setScale(2, RoundingMode.HALF_UP);
		BigDecimal DIME = new BigDecimal("0.10").setScale(2, RoundingMode.HALF_UP);
		BigDecimal NICKEL = new BigDecimal("0.05").setScale(2, RoundingMode.HALF_UP);
		BigDecimal PENNY = new BigDecimal("0.1").setScale(2, RoundingMode.HALF_UP);
		
		 
		BigDecimal reminder = payment.setScale(2, RoundingMode.UNNECESSARY).subtract(unit_price.setScale(2, RoundingMode.UNNECESSARY));
		
		BigDecimal dollars = reminder.divide(DOLLAR).setScale(0, RoundingMode.DOWN);
		reminder = reminder.remainder(DOLLAR);
		dollars.setScale(0, RoundingMode.HALF_EVEN);
		
		BigDecimal quarters = reminder.divide(QUARTER).setScale(0, RoundingMode.DOWN);
		reminder = reminder.remainder(QUARTER);
		quarters.setScale(0, RoundingMode.HALF_EVEN);
		
		BigDecimal dimes = reminder.divide(DIME).setScale(0, RoundingMode.DOWN);
		reminder = reminder.remainder(DIME);
		dimes.setScale(0, RoundingMode.HALF_EVEN);
		
		BigDecimal nickels = reminder.divide(NICKEL).setScale(0, RoundingMode.HALF_EVEN);
		reminder = reminder.remainder(NICKEL);
		nickels.setScale(0, RoundingMode.HALF_EVEN);
		
		BigDecimal pennies = reminder.divide(PENNY).setScale(0, RoundingMode.CEILING);
		reminder = reminder.remainder(PENNY);
		pennies.setScale(0, RoundingMode.CEILING);
				
		Map<String,BigDecimal> change = new HashMap<String,BigDecimal>();
		
		change.put("DOLLARS", dollars);
		change.put("QUARTERS", quarters);
		change.put("DIMES", dimes);
		change.put("NICKELS", nickels);
		change.put("PENNIES", pennies);
		
		return change;
	}

}
