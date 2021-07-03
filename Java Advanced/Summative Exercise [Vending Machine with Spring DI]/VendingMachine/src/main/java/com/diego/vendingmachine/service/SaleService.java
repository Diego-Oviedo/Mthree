package com.diego.vendingmachine.service;

import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Sale;

public interface SaleService {

	public Sale entrySale(Inventory inventory, Sale sale);
	
}
