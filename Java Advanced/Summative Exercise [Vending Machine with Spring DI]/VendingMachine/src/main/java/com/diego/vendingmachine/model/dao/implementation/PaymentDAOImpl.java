package com.diego.vendingmachine.model.dao.implementation;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;
import com.diego.vendingmachine.model.dto.Cent.Denominations;

@Component("payment_dao")
public class PaymentDAOImpl implements PaymentDAO {

	public Map<String, BigDecimal> getChange(BigDecimal payment, BigDecimal unit_price) throws DataSourceException {

		BigDecimal DOLLAR = new Cent().getDenomination(Denominations.DOLLAR);
		BigDecimal QUARTER = new Cent().getDenomination(Denominations.QUARTER);
		BigDecimal DIME = new Cent().getDenomination(Denominations.DIME);
		BigDecimal NICKEL = new Cent().getDenomination(Denominations.NICKEL);
		BigDecimal PENNY = new Cent().getDenomination(Denominations.PENNY); 

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

		Map<String, BigDecimal> change = new HashMap<String, BigDecimal>();

		change.put("DOLLARS", dollars);
		change.put("QUARTERS", quarters);
		change.put("DIMES", dimes);
		change.put("NICKELS", nickels);
		change.put("PENNIES", pennies);

		return change;
	}

}
