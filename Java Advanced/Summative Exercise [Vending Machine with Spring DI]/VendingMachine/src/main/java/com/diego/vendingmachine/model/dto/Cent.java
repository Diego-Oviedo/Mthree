package com.diego.vendingmachine.model.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.diego.vendingmachine.model.dao.DataSourceException;

public class Cent {

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
}
