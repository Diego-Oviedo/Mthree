package com.diego.vendingmachine.model.dao;

import com.diego.vendingmachine.model.dto.*;

public interface InventoryDAO {
	
	public Inventory createInventory (String file_name) throws DataSourceException,InventoryException;
	
	public Inventory retreiveInventory () throws DataSourceException,InventoryException;
	
	public Inventory updateInventory () throws DataSourceException,InventoryException;

	public Inventory deleteInventory () throws DataSourceException,InventoryException;
}
