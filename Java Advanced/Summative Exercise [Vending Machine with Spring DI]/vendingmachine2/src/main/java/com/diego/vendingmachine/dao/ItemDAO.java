package com.diego.vendingmachine.dao;

import com.diego.vendingmachine.dto.*;


import java.util.*;

public interface ItemDAO {

	public Item addItem(Item item) throws DataSourceException, InventoryException;
	
	public Item getItem(String SKU) throws DataSourceException, InventoryException;
	
	public Item findItembyDescription(String item_description) throws DataSourceException, InventoryException;
	
	public Item editItem(String SKU,Item item) throws DataSourceException, InventoryException;
	
	public Item removeItem(String SKU) throws DataSourceException, InventoryException;
	
	public List<Item> getAllItems() throws DataSourceException, InventoryException;
	
	
}
