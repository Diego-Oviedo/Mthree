package com.diego.vendingmachine.service;

import java.util.*;
import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.dto.*;

public interface ItemService {
	
	public Item createItem(Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException;
	
	public Item retreiveItem(String SKU) throws DataSourceException, InventoryException;
	
	public Item retreiveItembyDescription(String item_description) throws DataSourceException, InventoryException;
	
	public Item updateItem(String SKU,Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException;
	
	public Item deleteItem(String SKU) throws DataSourceException, InventoryException, vendingMachinePersistenceException;
	
	public List<Item> retreiveAllItems() throws DataSourceException, InventoryException;

}
