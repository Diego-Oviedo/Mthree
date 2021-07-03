package com.diego.vendingmachine.model.dao;

import com.diego.vendingmachine.model.dto.*;

public interface InventoryDAO {
	
	public Inventory addInventory (String file_name) throws DataSourceException,InventoryException;
	
	public Inventory getInventory () throws DataSourceException,InventoryException;
	
	public Inventory editInventory () throws DataSourceException,InventoryException;

	public Inventory removeInventory () throws DataSourceException,InventoryException;
}
