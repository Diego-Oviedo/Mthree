package com.diego.vendingmachine.service;

import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.dto.*;

public interface SaleService {

	public Item entrySale(Item item) throws NoItemInventoryException, vendingMachinePersistenceException, DataSourceException, InventoryException;
	
	}
