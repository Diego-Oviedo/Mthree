package com.diego.vendingmachine.service;

import java.io.IOException;

import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

	public interface InventoryService {

	public Inventory createInventory (String file_name) throws DataSourceException,InventoryException, vendingMachinePersistenceException, IOException;
	
	public Inventory retreiveInventory () throws DataSourceException,InventoryException;
	
	public Inventory updateInventory () throws DataSourceException,InventoryException, vendingMachinePersistenceException;

	public Inventory deleteInventory () throws DataSourceException,InventoryException, vendingMachinePersistenceException;
}