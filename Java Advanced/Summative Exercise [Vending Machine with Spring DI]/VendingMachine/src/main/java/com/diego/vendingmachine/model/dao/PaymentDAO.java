package com.diego.vendingmachine.model.dao;

import java.math.BigDecimal;
import com.diego.vendingmachine.model.dto.*;
import java.util.*;

public interface PaymentDAO {

	public Map<String,BigDecimal> getChange (BigDecimal payment, BigDecimal unit_price) throws DataSourceException;
}
