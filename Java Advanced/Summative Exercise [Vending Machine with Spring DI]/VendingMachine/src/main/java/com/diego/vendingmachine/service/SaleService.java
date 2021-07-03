package com.diego.vendingmachine.service;

import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

public interface SaleService {

	public Item entrySale(Inventory inventory, Sale sale) throws NoItemInventoryException, vendingMachinePersistenceException, DataSourceException;
	
}
